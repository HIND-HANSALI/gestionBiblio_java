package org.example;
import database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auteur {
    private static Connection connection = Dbconnection.getConnection();
    public int id;
    public String name;
    public Auteur(int id, String name) {
        this.id = id;
        this.name = name;

    }
    public Auteur() {

    }
    public Auteur(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public void createAuteur(){
        String sqlQuery = "INSERT INTO auteurs (name) VALUES (?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1,this.name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Auteur getAuthor(String name){
        Auteur auteur = new Auteur();
        String sqlQuery = "SELECT * FROM auteurs WHERE name = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                auteur.name = resultSet.getString("name");
                auteur.id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auteur;
    }





    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getters & setters
    public int getId() {
        return id;
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
}
