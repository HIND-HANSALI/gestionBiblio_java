package org.example;
import java.lang.reflect.Array;
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
    private int statut;



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

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }



    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }


    /*public Livre(int id,String title,String numIsbn,int qteTotal,int qtePerdu,int qteEmprunter,Auteur auteurId,int statut){
        this.id=id;
        this.title=title;
        this.numIsbn=numIsbn;
         this.qteTotal=qteTotal;
        this.qtePerdu=qtePerdu;
        this.qteEmprunter=qteEmprunter;
        this.auteurId=auteurId;
        this.statut=statut;

    }*/

    //methodes
    /*public Livre ajouterLivre(int id,String title,...){
        return new Livre();
    }
    */

    public Livre editLivre(int id){
    return new Livre();
    }
    public Livre modifierLivre(String newTitle, String newNumIsbn, int newQteTotal, int newQtePerdu, int newQteEmprunter, Auteur newAuteur, int newStatut){
        return new Livre();
    }
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
