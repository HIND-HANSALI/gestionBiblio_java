package org.example;
import database.Dbconnection;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Livre {
    private int id;
    private String title;
    private String numIsbn;
    private int qteTotal;
    private int qtePerdu;
    private int qteEmprunter;
    private Auteur auteur;

    private int qtedisponible;

    private Bibliothecaire bibliotecaire;

    public Livre(){}

    public Livre(int id, String title, String numIsbn, int qteTotal, int qtePerdu, int qteEmprunter, Auteur auteur, int qtedisponible, Bibliothecaire bibliotecaire) {
        this.id = id;
        this.title = title;
        this.numIsbn = numIsbn;
        this.qteTotal = qteTotal;
        this.qtePerdu = qtePerdu;
        this.qteEmprunter = qteEmprunter;
        this.auteur = auteur;
        this.qtedisponible = qtedisponible;
        this.bibliotecaire = bibliotecaire;
    }

    public int getQtedisponible() {
        return qtedisponible;
    }

    public void setQtedisponible(int qtedisponible) {
        this.qtedisponible = qtedisponible;
    }

    public Bibliothecaire getBibliotecaire() {
        return bibliotecaire;
    }

    public void setBibliotecaire(Bibliothecaire bibliotecaire) {
        this.bibliotecaire = bibliotecaire;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumIsbn() {
        return numIsbn;
    }

    public void setNumIsbn(String numIsbn) {
        this.numIsbn = numIsbn;
    }

    public int getQteTotal() {
        return qteTotal;
    }

    public void setQteTotal(int qteTotal) {
        this.qteTotal = qteTotal;
    }

    public int getQtePerdu() {
        return qtePerdu;
    }

    public void setQtePerdu(int qtePerdu) {
        this.qtePerdu = qtePerdu;
    }

    public int getQteEmprunter() {
        return qteEmprunter;
    }

    public void setQteEmprunter(int qteEmprunter) {
        this.qteEmprunter = qteEmprunter;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    /*public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }
*/


    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }


    public void getAllBooks() throws SQLException {
        try (Connection con = Dbconnection.getConnection();) {

            Statement st = con.createStatement();
            //String qr = "SELECT * FROM books INNER JOIN author ON books.authorId = author.id";
            String qr = "SELECT * FROM livres";
            ResultSet res = st.executeQuery(qr);
            while (res.next()) {
                //System.out.println(res.getString("title") + res.getString("authorName") + res.getInt("id"));
                System.out.println(res.getString("title") + res.getString("num_isbn") + res.getInt("id"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //methodes
    public void ajouterLivre(Livre livre){

        //Etablir connexion bdd
        Connection connection = Dbconnection.getConnection();
        if (connection == null) {
            System.err.println("Failed to connect to the database.");

        }
        try {
            //insertion livre
            String sql = "INSERT INTO livres (num_isbn, title, qteTotal, qtePerdu, qteEmprunte,qteDisponible, auteur_id, bibliotecaire_id) VALUES (?,?,?,?,?,?,?,?)";

            //preparer requete
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, livre.getNumIsbn());
            statement.setString(2, livre.getTitle());
            statement.setInt(3, livre.getQteTotal());
            statement.setInt(4, livre.getQtePerdu());
            statement.setInt(5, livre.getQteEmprunter());
            statement.setInt(6, livre.getQtedisponible());
            statement.setInt(7, livre.getAuteur().getId());
            statement.setInt(8, livre.getBibliotecaire().getId());

            statement.executeUpdate();
        }catch (
                SQLException e) {
            System.out.println("Aucune connexion n'a été établie.");
        }

    }





    public Livre editLivre(int id){
    return new Livre();
    }
    /*public Livre modifierLivre(String newTitle, String newNumIsbn, int newQteTotal, int newQtePerdu, int newQteEmprunter, Auteur newAuteur, int newStatut){
        return new Livre();
    }*/
    public boolean supprimerLivre(String isbn){
        return true;
    }


    public List<Livre> afficherLivreEmprunter(){
        List<Livre> livresEmpruntes = new ArrayList<>();
        return livresEmpruntes;
    }




    public List<Livre> afficherAllLivres(){
        List<Livre> Alllivres = new ArrayList<>();
        return Alllivres;
    }

    public Livre chercherLivre(Livre livre){
        return livre;
    }
    public List<Livre> chercherLivreParISBN(String isbn){
        List<Livre> livresTrouves = new ArrayList<>();
        return livresTrouves;
    }

    public static void main(String[] args) {
        //Livre livre1 = new Livre(1, "Le nom du livre","A122",4,2,2,1,2);
        Livre livre1=new Livre();
        livre1.title="dernier jour";

        //livre1.setTitle("hind");
        System.out.println(livre1.getTitle());

    }
}
