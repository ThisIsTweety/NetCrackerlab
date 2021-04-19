package dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class DatabaseHandler {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/netcracker";
    static final String USER = "postgres";
    static final String PASS = "admin";
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DB_URL,USER, PASS);
        return connection;
    }
}
