package by.gsu.examples.example1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    private static Connection connection;

    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/gsuwinter?user=root&password=root"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
