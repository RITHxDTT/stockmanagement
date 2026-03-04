import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductList {
   List<Products> products = new ArrayList<>();

    public void addProduct() {
        try (Scanner sc = new Scanner(System.in);
             Connection con = DbConncetion.getConnection()) {

            if (con != null) {
                System.out.println("Database connected successfully!");
            }

            String sql = "INSERT INTO products(name, unitprice, qty, importdate) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            System.out.print("Please input Product Name: ");
            String name = sc.nextLine();

            System.out.print("Please input Unit Price: ");
            double unitPrice = sc.nextDouble(); sc.nextLine();

            System.out.print("Please input Quantity: ");
            int qty = sc.nextInt(); sc.nextLine();

            System.out.print("Please input Date (yyyy-mm-dd): ");
            String date = sc.nextLine();

            java.sql.Date sqlDate;
            try {
                sqlDate = java.sql.Date.valueOf(date);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format! Use yyyy-mm-dd");
                return;
            }

            ps.setString(1, name);
            ps.setDouble(2, unitPrice);
            ps.setInt(3, qty);
            ps.setDate(4, sqlDate);

            int row = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            products.add(new Products(id, name, unitPrice, qty, date));

            if (row == 1) {
                System.out.println("Add success! Product ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void updateProduct() {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DbConncetion.getConnection()) {

            String sql = "UPDATE products SET name = ?, unitprice = ?, qty = ?, importdate = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            // ===== Input values =====
            System.out.print("Please input product id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Please input new product name: ");
            String name = sc.nextLine();

            System.out.print("Please input new unit price: ");
            double unitPrice = sc.nextDouble();
            sc.nextLine();

            System.out.print("Please input new quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            System.out.print("Please input new date (yyyy-mm-dd): ");
            String date = sc.nextLine();

            // ===== Set values to PreparedStatement =====
            ps.setString(1, name);
            ps.setDouble(2, unitPrice);
            ps.setInt(3, qty);
            ps.setDate(4, java.sql.Date.valueOf(date));
            ps.setInt(5, id);

            int row = ps.executeUpdate();

            if (row == 1) {
                System.out.println("Update success");

                // ===== Update ArrayList =====
                for (int i = 0; i < products.size(); i++) {
                    if (id == products.get(i).getPrdId()) {

                        // Replace old object with new updated object
                        products.set(i, new Products(id, name, unitPrice, qty, date));
                    }
                }

            } else {
                System.out.println("Update not success (ID not found)");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format! Please use yyyy-mm-dd");
        }
    }


    public void deleteProduct() {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DbConncetion.getConnection()) {

            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);


            System.out.print("Please input product id to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row == 1) {
                System.out.println("Delete success");


                for (int i = 0; i < products.size(); i++) {
                    if (id == products.get(i).getPrdId()) {
                        products.remove(i);
                        break;
                    }
                }

            } else {
                System.out.println("Delete not success (ID not found)");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

    }

    public void showProducts() {

        products.clear();

        try (Connection con = DbConncetion.getConnection()) {

            String sql = "SELECT * FROM products";   // ← removed ORDER BY id
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("===== PRODUCT LIST =====");

            System.out.printf("%-5s %-15s %-10s %-5s %-12s%n",
                    "ID", "Name", "Price", "Qty", "Date");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("unitprice");
                int qty = rs.getInt("qty");
                String date = rs.getDate("importdate").toString();

                products.add(new Products(id, name, price, qty, date));

                System.out.printf("%-5d %-15s %-10.2f %-5d %-12s%n",
                        id, name, price, qty, date);
            }

            if (products.isEmpty()) {
                System.out.println("No products found.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }


}

