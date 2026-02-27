import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConncetion {
    private static final String userLogin = "javaMiniProject";
    private static final String password = "123";
    private static final String url = "jdbc:postgresql://localhost:5432/stockManagement";
    DbConncetion() throws SQLException {

//        load driver
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch(Exception e){
            System.out.println("System error " + e);
        }

//        connect to database
            try(Connection conn = DriverManager.getConnection(url, userLogin, password)){
                System.out.println("Connected to the database");
            }
            catch(Exception e){
                System.out.println("Error connecting to the database " + e.getMessage());
            }

    }
}
