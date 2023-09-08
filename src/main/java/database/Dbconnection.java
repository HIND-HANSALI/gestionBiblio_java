package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Create a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/gestion_biblio_minisas", "root", "");

        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }

        return connection;
    }
}