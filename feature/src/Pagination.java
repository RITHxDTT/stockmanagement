import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Pagination {

    public static List<Products> products = new ArrayList<>();

    public static int total = 0;
    public static int totalPage = 0;
    public static int pageIndex = 1;
    public static int row = 4;



    public static void loadProducts() throws SQLException {

        products.clear();

        Connection con = DbConncetion.getConnection();
        Statement stmt = con.createStatement();


        ResultSet countRs = stmt.executeQuery("SELECT COUNT(*) FROM products");

        if (countRs.next()) {
            total = countRs.getInt(1);
        }


        if (total % row == 0) {
            totalPage = total / row;
        } else {
            totalPage = (total / row) + 1;
        }


        ResultSet rs = stmt.executeQuery("SELECT * FROM products ORDER BY id");

        while (rs.next()) {

            Products p = new Products(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("unitPrice"),
                    rs.getInt("qty"),
                    rs.getString("importdate")
            );

            products.add(p);
        }

        showPage(1);
    }


//   load page
    public static void showPage(int pageNumber) {

        pageIndex = pageNumber;

        Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);

        t.addCell("ID");
        t.addCell("Name");
        t.addCell("Unit Price");
        t.addCell("Qty");
        t.addCell("Import Date");

        int start = (pageIndex - 1) * row;
        int end = start + row;

        if (end > products.size()) {
            end = products.size();
        }

        for (int i = start; i < end; i++) {

            Products p = products.get(i);

            t.addCell(String.valueOf(p.getPrdId()));
            t.addCell(p.getPrdName());
            t.addCell(String.valueOf(p.getUnitPrice()));
            t.addCell(String.valueOf(p.getQty()));
            t.addCell(p.getDate());
        }

        t.addCell("Page : " + pageIndex + " of " + totalPage,
                new CellStyle(CellStyle.HorizontalAlign.left), 2);

        t.addCell("Total Record : " + total,
                new CellStyle(CellStyle.HorizontalAlign.center), 3);

        System.out.println(t.render());
    }


// fist page
    public static void firstPage() {
        showPage(1);
    }

// last page
    public static void lastPage() {
        showPage(totalPage);
    }

// next
    public static void nextPage() {

        if (pageIndex < totalPage) {
            pageIndex++;
            showPage(pageIndex);
        } else {
            System.out.println(Colors.blue+"Already last page."+Colors.reset);
        }
    }

//    previous
    public static void previousPage() {

        if (pageIndex > 1) {
            pageIndex--;
            showPage(pageIndex);
        } else {
            System.out.println(Colors.blue+"Already first page."+Colors.reset);
        }
    }
}