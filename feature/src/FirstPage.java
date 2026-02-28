import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstPage {
    public static void firstPage() throws SQLException {
        try(Connection con = DbConncetion.getConnection()){
            NumberDisplay.pageIndex = 0;
            NumberDisplay.page =0;
//            retrive data
            String select = " select * from products ";

//            statement
            Statement stmt = con.createStatement();

//            Result stage
            ResultSet rs = stmt.executeQuery(select);
            Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);

//          2. Add Headers first
            t.addCell("ID");
            t.addCell("Name");
            t.addCell("Unit Price");
            t.addCell("Qty");
            t.addCell("Import Date");

            NumberDisplay.countRecord = 0;


            while(rs.next()){


                if(NumberDisplay.countRecord == 4){
                    NumberDisplay.pageIndex ++;
                    NumberDisplay.page++;

                    break;
                }


                // Add data rows
                t.addCell(rs.getString("id"));
                t.addCell(rs.getString("name"));
                t.addCell(rs.getString("unitPrice"));
                t.addCell(rs.getString("qty"));
                t.addCell(rs.getString("importdate"));

                NumberDisplay.countRecord++;

            }

            // 3. Add the Footer (spanning columns for that "cool" look)
            t.addCell("Page : " + NumberDisplay.pageIndex +" of " + NumberDisplay.totalPage, new CellStyle(CellStyle.HorizontalAlign.left), 2);
            t.addCell("Total Record :" + NumberDisplay.total , new CellStyle(CellStyle.HorizontalAlign.center), 3);

            // 4. Render ONCE at the end
            System.out.println(t.render());
        }
        catch(SQLException e){
            System.out.println(Colors.red+"error occured" + e.getMessage() + Colors.reset);
        }
    }
}
