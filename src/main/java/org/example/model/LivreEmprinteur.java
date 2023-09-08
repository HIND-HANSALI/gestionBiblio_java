package org.example.model;

import database.Dbconnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class LivreEmprinteur {
    private int livre_id;
    private int emprunteur_id;
    private Date dateEmprunt;
    private Date dateRetour;
    private  int quanity;


    public void emprint() {

        if (livre_id <= 0 || emprunteur_id <= 0) {
            System.out.println("Invalid livre_id or emprunteur_id.");
            return;
        }

        // Insert the book loan into the database

        String insertQuery = "INSERT INTO emprunte (livre_id, emprunteur_id,date_demprunt, date_retour, qte) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = Dbconnection.getConnection().prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, livre_id);
            preparedStatement.setInt(2, emprunteur_id);
            preparedStatement.setDate(3, new java.sql.Date(dateEmprunt.getTime()));
            preparedStatement.setDate(3, new java.sql.Date(dateRetour.getTime()));
            preparedStatement.setInt(2, quanity);
            preparedStatement.setDate(3, new java.sql.Date(dateEmprunt.getTime()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book loan saved successfully.");
            } else {
                System.out.println("Failed to save book loan.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(int livre_id) {
        this.livre_id = livre_id;
    }

    public int getEmprunteur_id() {
        return emprunteur_id;
    }

    public void setEmprunteur_id(int emprunteur_id) {
        this.emprunteur_id = emprunteur_id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
}
