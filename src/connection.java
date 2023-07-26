import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    static Connection connect;

    public static Connection create() {
        try {
            // For loading of DRIVERS
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL of schema's we have created at MySQL
            String url = "jdbc:mysql://localhost:3306/codepro_system";
            String user = "root";
            String pass = "1234";

            // For communication with the databases
            connect = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }
}