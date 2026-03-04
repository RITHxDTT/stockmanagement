import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchByName {
    static Scanner sc = new Scanner(System.in);

    public static void search() {
        System.out.print("Enter the name of the product you want to search: ");
        String searchName = sc.nextLine();

        String searchQuery = "SELECT * FROM products WHERE name iLIKE ?";

        try (Connection con = DbConncetion.getConnection();
             PreparedStatement pstmt = con.prepareStatement(searchQuery)) {

            pstmt.setString(1, "%" + searchName+ "%");

            try (ResultSet rs = pstmt.executeQuery()) {

                Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);
                t.addCell("ID");
                t.addCell("Name");
                t.addCell("Unit Price");
                t.addCell("Qty");
                t.addCell("Import Date");

                boolean isFound = false;
                int countRecord = 0;

                while (rs.next()) {
                    isFound = true;
                    t.addCell(rs.getString("id"));
                    t.addCell(rs.getString("name"));
                    t.addCell(rs.getString("unitPrice"));
                    t.addCell(rs.getString("qty"));
                    t.addCell(rs.getString("importDate"));
                    countRecord++;
                }

                if (isFound) {
                    t.addCell("Total Records Found: " + countRecord, new CellStyle(CellStyle.HorizontalAlign.center), 5);
                    System.out.println(t.render());
                    System.out.print("Press Enter to Continuous...");
                    sc.nextLine();
                } else {
                    System.out.println(Colors.red + "Don't have " + searchName + " in our stock"+  Colors.reset);
                    System.out.print("Press Enter to Continuous...");
                    sc.nextLine();
                }
            }

        } catch (SQLException e) {
            System.out.println("error connected to database: " + e.getMessage());
        }
    }
}
