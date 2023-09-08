package org.example;
import database.Dbconnection;
import helper.Printer;

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
    public Livre(String title, String numIsbn, int qteTotal, int qtePerdu, int qteEmprunter, Auteur auteur, int qtedisponible, Bibliothecaire bibliotecaire) {

        this.title = title;
        this.numIsbn = numIsbn;
        this.qteTotal = qteTotal;
        this.qtePerdu = qtePerdu;
        this.qteEmprunter = qteEmprunter;
        this.auteur = auteur;
        this.qtedisponible = qtedisponible;
        this.bibliotecaire = bibliotecaire;
    }
    public Livre(String title, int qteTotal, int qtePerdu, int qteEmprunter, Auteur auteur, int qtedisponible) {

        this.title = title;

        this.qteTotal = qteTotal;
        this.qtePerdu = qtePerdu;
        this.qteEmprunter = qteEmprunter;
        this.auteur = auteur;
        this.qtedisponible = qtedisponible;
        //this.bibliotecaire = bibliotecaire;
    }

    /*public Livre(String numIsbn, String title, String  auteur, String bibliotecaire, int qteTotal, int qtePerdu, int qteEmprunte, int qteDisponible) {
        this.title = title;
        this.numIsbn = numIsbn;
        this.qteTotal = qteTotal;
        this.qtePerdu = qtePerdu;
        this.qteEmprunter = qteEmprunte;
        this.auteur = auteur;
        this.qtedisponible = qteDisponible;
        this.bibliotecaire = bibliotecaire;
    }*/

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
        try (Connection con = Dbconnection.getConnection()) {

            Statement st = con.createStatement();
            //String qr = "SELECT * FROM books INNER JOIN author ON books.authorId = author.id";
            //String qr = "SELECT * FROM livres";
            String qr="SELECT title,num_isbn,auteurs.name as auteurs,bibliotecaires.name as bibliotecaires,qteTotal, qtePerdu,qteEmprunte,qteDisponible FROM livres INNER JOIN auteurs on livres.auteur_id=auteurs.id INNER JOIN bibliotecaires on livres.bibliotecaire_id=bibliotecaires.id";
            ResultSet res = st.executeQuery(qr);
            //String auteur = res.getString("auteurs");

            //String bibliotecaire = res.getString("bibliotecaires");
            while (res.next()) {
                System.out.println("Titre: " + res.getString("title") + ",Numero ISBN: " + res.getString("num_isbn")  );
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
        }catch (SQLException e) {
            System.out.println("Aucune connexion n'a été établie.");
        }

    }




    public void updateLivre(Livre livre ,  String livreisbn) {
        Connection connection = Dbconnection.getConnection();

        try {
            String sql = "UPDATE livres SET title=?,qteTotal=?, qtePerdu=?, qteEmprunte=?,qteDisponible=?, auteur_id=? WHERE num_isbn=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setString(1, livre.getNumIsbn());
            statement.setString(1, livre.getTitle());
            statement.setInt(2, livre.getQteTotal());
            statement.setInt(3, livre.getQtePerdu());
            statement.setInt(4, livre.getQteEmprunter());
            statement.setInt(5, livre.getQtedisponible());
            statement.setInt(6, livre.getAuteur().getId());
            statement.setString(7, livreisbn);
            //statement.setInt(7, livre.getBibliotecaire().getId());

            System.out.println(statement);


             statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Aucune connexion n'a été établie.");

        }

    }
    public void ShowBookByIsbn(String isbn) {
        Connection connection = Dbconnection.getConnection();

        try {
            //String sql1 = "SELECT * FROM livres WHERE num_isbn=? ";
            String sql="SELECT title,num_isbn,auteurs.name as auteurs,bibliotecaires.name as bibliotecaires,qteTotal, qtePerdu,qteEmprunte,qteDisponible FROM livres INNER JOIN auteurs on livres.auteur_id=auteurs.id INNER JOIN bibliotecaires on livres.bibliotecaire_id=bibliotecaires.id where num_isbn=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, isbn);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                //System.out.println("hind");
                String isbnum = resultSet.getString("num_isbn");
                String title = resultSet.getString("title");
                String auteur = resultSet.getString("auteurs");
                String bibliotecaire = resultSet.getString("bibliotecaires");
                int qteTotal= resultSet.getInt("qteTotal");
                int qtePerdu= resultSet.getInt("qtePerdu");
                int qteEmprunte = resultSet.getInt("qteEmprunte");
                int qteDisponible = resultSet.getInt("qteDisponible");

                System.out.println("Titre: " + title + ",Numero ISBN:"+isbnum+", Auteur: " + auteur + ", Bibliothécaire: " + bibliotecaire + ", Quantité totale: " + qteTotal + ", Quantité perdue: " + qtePerdu + ", Quantité empruntée: " + qteEmprunte + ", Quantité disponible: " + qteDisponible);


            } else {
                System.out.println("No book with this isbn");
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());

        }
    }
    public void searchBookByTitle(String title){
        Connection connection = Dbconnection.getConnection();


        try {
            //String sql1 = "SELECT * FROM livres WHERE num_isbn=? ";
            String sql="SELECT title,num_isbn,auteurs.name as auteurs,bibliotecaires.name as bibliotecaires,qteTotal, qtePerdu,qteEmprunte,qteDisponible FROM livres INNER JOIN auteurs on livres.auteur_id=auteurs.id INNER JOIN bibliotecaires on livres.bibliotecaire_id=bibliotecaires.id WHERE auteurs.name LIKE ? OR title LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + title + "%");
            statement.setString(2, "%" + title + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                //System.out.println("hind");

                String titlee = resultSet.getString("title");
                String auteur1 = resultSet.getString("auteurs");
                String bibliotecaire = resultSet.getString("bibliotecaires");
                int qteTotal= resultSet.getInt("qteTotal");
                int qtePerdu= resultSet.getInt("qtePerdu");
                int qteEmprunte = resultSet.getInt("qteEmprunte");
                int qteDisponible = resultSet.getInt("qteDisponible");

                System.out.println("Titre: " + titlee + ", Auteur: " + auteur1 + ", Bibliothécaire: " + bibliotecaire + ", Quantité totale: " + qteTotal + ", Quantité perdue: " + qtePerdu + ", Quantité empruntée: " + qteEmprunte + ", Quantité disponible: " + qteDisponible);


            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());

        }

    }


    public int DeleteBook(String title,String isbn) throws Exception{
        int status = 0;
        try {
            Connection connection = Dbconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM livres WHERE livres.title = ? and livres.num_isbn = ?");
            ps.setString(1, title);
            ps.setString(2, isbn);
            status = ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }
    public int RemoveBook(String isbn) throws Exception{
        int status = 0;
        try {
            Connection connection = Dbconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM livres WHERE  livres.num_isbn = ?");
            ps.setString(1, isbn);

            status = ps.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return status;
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




    public  Livre getLivreBySbn(String sbn)  {
        String query = "SELECT * FROM livres WHERE num_isbn = ?";
        try (PreparedStatement preparedStatement =Dbconnection.getConnection().prepareStatement(query)) {
            try {
                preparedStatement.setString(1, sbn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return mapData(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  Livre mapData(ResultSet resultSet)  {
        try {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String numIsbn = resultSet.getString("num_isbn");
                int qteTotal = resultSet.getInt("qteTotal");
                int qtePerdu = resultSet.getInt("qtePerdu");
                int qteEmprunter = resultSet.getInt("qteEmprunte");
                int qtedisponible = resultSet.getInt("qteDisponible");



                Livre livre = new Livre();
                livre.setId(id);
                livre.setTitle(title);
                livre.setNumIsbn(numIsbn);
                livre.setQteTotal(qteTotal);
                livre.setQtePerdu(qtePerdu);
                livre.setQteEmprunter(qteEmprunter);
                livre.setQtedisponible(qtedisponible);

                return livre;
            } else {
                return null; // No data in the ResultSet
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
         Livre livre = new Livre();

        Printer.printModel(livre.getLivreBySbn("YU876"));
    }

}
