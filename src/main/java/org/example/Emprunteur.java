package org.example;

import database.Dbconnection;
import helper.Printer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Emprunteur {
    public int id;
    public String name;
    public String email;
    public String cin;

    public Emprunteur(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emprunteur(int id, String name, String email, String cin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cin = cin;
    }

    public Emprunteur() {

    }

    public int getId(){
        return id;
    }

    public  Emprunteur getEmprunteurByCin(String cin) {
        String query = "SELECT * FROM emprunteurs WHERE cin = ?";
        try (PreparedStatement preparedStatement = Dbconnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, cin);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return mapData(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  Emprunteur mapData(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String cin = resultSet.getString("cin");

                return new Emprunteur(id, name, email, cin);
            } else {
                return null; // No data in the ResultSet
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    public static void main(String[] args) {
        // Your code for the Emprunteur class goes here
    }
}

