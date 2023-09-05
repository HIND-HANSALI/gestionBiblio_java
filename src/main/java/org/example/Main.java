package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql", "root", "");
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("NO Connection Was made");
        }
    }
}