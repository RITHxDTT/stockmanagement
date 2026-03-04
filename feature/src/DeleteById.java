import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteById {
    static Scanner sc = new Scanner(System.in);

    public static void deleteData() {
        try (Connection con = DbConncetion.getConnection()) {
            while (true) {
                System.out.print(Colors.cyan+"Enter the ID of the product you want to delete: "+Colors.reset);
                String productId = sc.nextLine();
                String regex = "^\\d{1,2}$";

                if (productId.matches(regex)) {
                    String deleteQuery = "DELETE FROM products WHERE id = ?";

                    try (PreparedStatement pstmt = con.prepareStatement(deleteQuery)) {
                        pstmt.setInt(1, Integer.parseInt(productId));

                        int rowsAffected = pstmt.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println(Colors.green+"Product ID " + productId + " was successfully deleted."+ Colors.reset);
                            System.out.print(Colors.yellow+"Press Enter to Continuous....."+Colors.reset);
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println(Colors.red + "Product ID not found in database. Cannot delete." + Colors.reset);
                            System.out.print(Colors.yellow+"Press Enter to Continuous....."+Colors.reset);
                            sc.nextLine();
                        }
                    }
                } else {
                    System.out.println(Colors.red + "Please follow the command instruction" + Colors.reset);
                }
            }
        } catch (SQLException e) {
            System.out.println(Colors.red+"error connected to database: " + e.getMessage()+Colors.reset);
        }
    }
}