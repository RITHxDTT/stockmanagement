import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pagination {
    public static int countRecord = 0;
    public static  int page = 0;
    public static int total =0;
    public static int totalPage = 0;
    public static int pageIndex = 1;
    public static int row = 3;
//    first page
public static void firstPage() throws SQLException {

    pageIndex = 1;

    try (Connection con = DbConncetion.getConnection()) {

        int temperIndex = 0;

        String select = "SELECT * FROM products ORDER BY id LIMIT "
                + row + " OFFSET " + temperIndex;

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);

        Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);

        // Header
        t.addCell("ID");
        t.addCell("Name");
        t.addCell("Unit Price");
        t.addCell("Qty");
        t.addCell("Import Date");

        while (rs.next()) {
            t.addCell(rs.getString("id"));
            t.addCell(rs.getString("name"));
            t.addCell(rs.getString("unitPrice"));
            t.addCell(rs.getString("qty"));
            t.addCell(rs.getString("importdate"));
        }

        // Footer
        t.addCell("Page : " + pageIndex + " of " + totalPage,
                new CellStyle(CellStyle.HorizontalAlign.left), 2);

        t.addCell("Total Record : " + total,
                new CellStyle(CellStyle.HorizontalAlign.center), 3);

        System.out.println(t.render());

    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

// last page
public static void lastPage() throws SQLException {

    pageIndex = totalPage;

    try (Connection con = DbConncetion.getConnection()) {

        int tempPage = (pageIndex - 1) * row;

        String select = "SELECT * FROM products ORDER BY id LIMIT "
                + row + " OFFSET " + tempPage;

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);

        Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);

        // Header
        t.addCell("ID");
        t.addCell("Name");
        t.addCell("Unit Price");
        t.addCell("Qty");
        t.addCell("Import Date");

        while (rs.next()) {
            t.addCell(rs.getString("id"));
            t.addCell(rs.getString("name"));
            t.addCell(rs.getString("unitPrice"));
            t.addCell(rs.getString("qty"));
            t.addCell(rs.getString("importdate"));
        }

        // Footer
        t.addCell("Page : " + pageIndex + " of " + totalPage,
                new CellStyle(CellStyle.HorizontalAlign.left), 2);

        t.addCell("Total Record : " + total,
                new CellStyle(CellStyle.HorizontalAlign.center), 3);

        System.out.println(t.render());

    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

//next page
public static void nextPage() throws SQLException {

    // prevent overflow
    if (pageIndex >= totalPage) {
        System.out.println("You are already at last page.");
        return;
    }

    pageIndex++;   // move to next page

    try (Connection con = DbConncetion.getConnection()) {

        int offset = (pageIndex - 1) * row;

        String select = "SELECT * FROM products ORDER BY id LIMIT "
                + row + " OFFSET " + offset;

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);

        Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);

        // Header
        t.addCell("ID");
        t.addCell("Name");
        t.addCell("Unit Price");
        t.addCell("Qty");
        t.addCell("Import Date");

        while (rs.next()) {
            t.addCell(rs.getString("id"));
            t.addCell(rs.getString("name"));
            t.addCell(rs.getString("unitPrice"));
            t.addCell(rs.getString("qty"));
            t.addCell(rs.getString("importdate"));
        }

        // Footer
        t.addCell("Page : " + pageIndex + " of " + totalPage,
                new CellStyle(CellStyle.HorizontalAlign.left), 2);

        t.addCell("Total Record : " + total,
                new CellStyle(CellStyle.HorizontalAlign.center), 3);

        System.out.println(t.render());

    } catch (SQLException e) {
        System.out.println(Colors.red + "error occured "
                + e.getMessage() + Colors.reset);
    }
}

//show products
public static void displayProductName() throws SQLException {
    try(Connection con = DbConncetion.getConnection()){

//            create statement
        Statement stmt = con.createStatement();

//            retrive data
        String select = """
                    select * from products
                    """;

        String selectSumRecord = """
                    select count(*) from products;
                    """;

        ResultSet sumRecord = stmt.executeQuery(selectSumRecord);

        while(sumRecord.next()){
            total = sumRecord.getInt(1);
        }



//          execute quary
        ResultSet rs = stmt.executeQuery(select);
        Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);

//          2. Add Headers first
        t.addCell("ID");
        t.addCell("Name");
        t.addCell("Unit Price");
        t.addCell("Qty");
        t.addCell("Import Date");

        countRecord = 0;
        while(rs.next()){

            if(countRecord == 4){
                page = 1;
                break;
            }

            // Add data rows
            t.addCell(rs.getString("id"));
            t.addCell(rs.getString("name"));
            t.addCell(rs.getString("unitPrice"));
            t.addCell(rs.getString("qty"));
            t.addCell(rs.getString("importdate"));
            countRecord++;

        }

//        calculate total record

        if(total%4 !=0){
            totalPage = (total/4) + 1;
        }
        else{
            totalPage = (total/4)  ;
        }



        // 3. Add the Footer
        t.addCell("Page : " + page +" of " + totalPage, new CellStyle(CellStyle.HorizontalAlign.left), 2);
        t.addCell("Total Record :" + total , new CellStyle(CellStyle.HorizontalAlign.center), 3);

        // 4. Render
        System.out.println(t.render());

    }
    catch(SQLException e){
        System.out.println("error connected to database: " + e.getMessage());
    }
}
}
