package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    private static final String URL= System.getenv().getOrDefault("DB_URL","jdbc:mysql://localhost:3306/garage");
    private static final String USER= System.getenv().getOrDefault("DB_USER","root");
    private static final String PASS= System.getenv().getOrDefault("DB_PASS","Rohit@123");

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MYSQL JDBC Driver not found", e);
        }
    }
        public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(URL,USER,PASS);
        }
}
