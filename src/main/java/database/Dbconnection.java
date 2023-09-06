package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {


    private static Connection connection;
    public static Connection getConnection() {

        if (connection == null) {
            try {
                // Create a connection to the database
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/gestion_biblio_minisas", "root", "");
                System.out.println("Connected to the database");
            } catch (SQLException e) {
                System.err.println("Error connecting to the database: " + e.getMessage());
            }
        }
        return connection;
    }
}
