



import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;




import java.sql.*;
import java.util.Scanner;




public class ReadById {
    public void displayProductById() throws SQLException {
        Scanner sc = new Scanner(System.in);
        InputString input = new InputString();


        while (true){
            System.out.print(Colors.cyan +"Enter Product Id to search : "+Colors.reset);
            String id = sc.nextLine();
            Integer Id = 0;
            if(input.idValidate(id)){
                Id = Integer.parseInt(id);
                try(Connection con = DbConncetion.getConnection()){




                    String sql = "  select * from products where id = ? "  ;




                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setInt(1,Id);








                    ResultSet rs = preparedStatement.executeQuery();
                    if(rs.next()){
                        Table t = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);




                        t.addCell("ID");
                        t.addCell("Name");
                        t.addCell("Unit Price");
                        t.addCell("Qty");
                        t.addCell("Import Date");




                        t.addCell(rs.getString("id"));
                        t.addCell(rs.getString("name"));
                        t.addCell(rs.getString("unitPrice"));
                        t.addCell(rs.getString("qty"));
                        t.addCell(rs.getString("importdate"));




                        System.out.println(t.render());




                        System.out.println(Colors.yellow+"Do you want to continue? (y/n)"+Colors.reset);
                        String confirm = sc.nextLine();
                        if("Y".equalsIgnoreCase(confirm)){




                        }else {
                            System.out.println(Colors.blue+"Press enter to continue..."+Colors.reset);
                            sc.nextLine();
                            break;
                        }




                    }
                    else {
                        System.out.println(Colors.red+"Product ID not found"+Colors.reset);




                    }




                }
                catch(SQLException e){
                    System.out.println(Colors.red+"error connected to database: " + e.getMessage()+Colors.reset);
                }




            }else {
                System.out.println(Colors.red+"Please input number only"+Colors.reset);




            }




        }




    }




}




















