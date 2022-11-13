package JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    public static Connection connectToDB(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clicktocareer","postgres","Darshan@1962");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
