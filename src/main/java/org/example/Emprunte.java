package org.example;

import database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Emprunte {
    private int id;
    private Livre livre;
    public Emprunte(){

    }
    public Emprunte(Livre livre, Emprunteur emprunteur, int quantite, Date dateEmprunt, Date dateRetour) {

        this.livre = livre;
        this.emprunteur = emprunteur;
        this.quantite = quantite;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    private Emprunteur emprunteur;
    private int quantite;
    private Date dateEmprunt;
    private Date dateRetour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    public void emprunterLivre(Emprunte emprunte) {

        Connection connection = Dbconnection.getConnection();
        if (connection == null) {
            System.err.println("Failed to connect to the database.");
            return;
        }
        try {
            // Insert borrow record
            String sql = "INSERT INTO emprunte (livre_id, emprunteur_id, date_demprunt, date_retour, qte) VALUES (?,?,Now(),?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, this.getLivre().getId());
            statement.setInt(2, this.getEmprunteur().getId());
            statement.setDate(3, new java.sql.Date(dateEmprunt.getTime()));
            statement.setDate(4, new java.sql.Date(dateRetour.getTime()));
            statement.setInt(5, this.quantite);

            System.out.println(statement);

            statement.executeUpdate();

            // update dispo du livre   qte Disponible - qte
            /*sql = "UPDATE livres SET qteDisponible = qteDisponible - ? WHERE livre_id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(sql);

            updateStatement.setInt(1, livre.getQtedisponible());
            updateStatement.setInt(2, this.quantite);

            updateStatement.executeUpdate();*/
        } catch (SQLException e) {
            System.out.println("An error occurred while borrowing the book: " + e.getMessage());
        }
    }

}
