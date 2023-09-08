package org.example;

import database.Dbconnection;
import org.example.console.EmprintView;

import java.sql.*;
import java.util.Date;

import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        /*try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/gestion_biblio_minisas", "root", "");
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("NO Connection Was made");
        }*/

        Dbconnection.getConnection();
        Livre livre=new Livre();
        Scanner scanner = new Scanner(System.in);
        while (true)  {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
           System.out.println("5. Delete Book");
            System.out.println("6. List Books");
            System.out.println("7. Emprinter Book");
           System.out.println("8. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("-----------------------------------------");
            switch (choice) {
               case 1:
                   System.out.println("1. Insert New Book Informations");

                   /*System.out.print("Enter the id book: ");
                   int id = scanner.nextInt();
                   scanner.nextLine();*/

                   System.out.print("Enter the title of the book: ");
                   String title = scanner.nextLine();


                   System.out.println("Enter the author name of the book:");
                   String author_name = scanner.nextLine();
                   Auteur auteur = Auteur.getAuthor(author_name);
                   if(auteur.getId() == 0){
                       auteur = new Auteur(0,author_name);
                       auteur.createAuteur();
                       auteur = Auteur.getAuthor(author_name);
                   }
                   //System.out.println("Enter the bibliothecaire name of the book:");
                   //String librarian_name = scanner.nextLine();
                   //Bibliothecaire bibliotecaire = new Bibliothecaire(1,librarian_name);

                   Bibliothecaire bibliotecaire = new Bibliothecaire(1,"hind");

                   System.out.println("Enter book ISBN:");
                   String numIsbn = scanner.nextLine();

                   System.out.println("Enter book QuantityTotal:");
                   int quantityTotal = scanner.nextInt();

                   //System.out.println("Enter book quantity Lost:");
                   //int quantityLost = scanner.nextInt();
                   int quantityLost=0;
                   //System.out.println("Enter book quantity Reserved:");
                   //int quantityReserved = scanner.nextInt();
                   int quantityReserved =0;
                   //System.out.println("Enter book quantity Available:");
                   int quantityAvailable = quantityTotal;



                   Livre nouveauLivre = new Livre(title,numIsbn ,quantityTotal,quantityLost,quantityReserved,auteur,quantityAvailable,bibliotecaire);
                   livre.ajouterLivre(nouveauLivre);
                   break;
                case 2 :
                    System.out.print("Enter ISBN of the book to update: ");
                    String livreisbn = scanner.next();
                     livre.ShowBookByIsbn(livreisbn);

                    System.out.print("Enter new title: ");
                    String newTitle = scanner.next();
                    scanner.nextLine();

                    //Bibliothecaire bibliotecairee = new Bibliothecaire(1,"hind");
                    Auteur auteure = new Auteur(1,"victor");

                    System.out.print("Enter new book QuantityTotal:");
                    int newquantityTotal = scanner.nextInt();

                    System.out.print("Enter new book quantity Lost:");
                    int newquantityLost = scanner.nextInt();

                    System.out.print("Enter new book quantity Reserved:");
                    int newquantityReserved = scanner.nextInt();

                    System.out.print("Enter new book quantity Available:");
                    int newquantityAvailable = scanner.nextInt();

                    Livre updatedBook = new Livre(newTitle, newquantityTotal,newquantityLost, newquantityReserved,auteure,newquantityAvailable);
                    livre.updateLivre(updatedBook , livreisbn);

                     break;
                case 3:
                    System.out.println("Reserve Your Book");
                    System.out.print("Enter isbn Book you want to  borrow: ");
                    String isbnBook = scanner.next();
                    Livre livreinstance= new Livre();
                    Livre livreemp = livreinstance.getLivreBySbn(isbnBook);

                    System.out.print("Enter the CIN of the borrower: ");
                    String cinBorrower = scanner.next();
                    Emprunteur emprunteurcin=new Emprunteur().getEmprunteurByCin(cinBorrower);

                    System.out.print("Enter the quantity of the books: ");
                    String qteBook = scanner.next();



                    Emprunte emprunte=new Emprunte();
                    Emprunte newEmprunte = new Emprunte();
                    //emprunte.emprunterLivre(livreemp,emprunteurcin,dateemprunt,dateRetour,qteBook);



                    /*Emprunteur emprunteur = new Emprunteur(1,"emp");

                    Auteur auteuremp = new Auteur(1, "victor", "victor@gmail.com");

                    Bibliothecaire bibliotecaireemp = new Bibliothecaire(1, "hind","hind@gmail.com");

                    Livre livreEmp = new Livre(7,"aaaaaaaaaa","testisbn",111,1,2,auteuremp,2,bibliotecaireemp);

                    Date dateEmprunt = new Date();
                    Date dateRetour = new Date(System.currentTimeMillis() + 86400000);

                    //Timestamp date = new Timestamp(new Date().getTime());
                    //ps.setTimestamp(4, date);

                    int qte =2;
                    Emprunte emprunte=new Emprunte();
                    Emprunte newemprunte=new Emprunte(livreEmp,emprunteur,qte,dateEmprunt,dateRetour );
                    emprunte.emprunterLivre(newemprunte);*/
                case 8:
                    System.out.print("Enter the title or auteur of the book to search: ");
                    String livretitle= scanner.next();
                    livre.searchBookByTitle(livretitle);
                    break;
                case 5:
                    //remove book
                    //RemoveBook
                    System.out.print("Enter book ISBN : ");
                    String isbn = scanner.nextLine();
                    int status = livre.RemoveBook(isbn);
                    if(status == 1 )
                    {
                        System.out.println("Book deleted successfully");
                    }
                    else
                    {
                        System.out.println("ERROR while deleting product");
                    }
                    break;
                case 4:
                    System.out.println("Enter Book Name");
                    String name = scanner.nextLine();
                    System.out.println("Enter book ISBN");
                    String isbn1 = scanner.nextLine();

                    int status1 = livre.DeleteBook(name,isbn1);
                    if(status1 == 1 )
                    {
                        System.out.println("Book deleted successfully");
                    }
                    else
                    {
                        System.out.println("ERROR while deleting product");
                    }
                    break;
                case 6:
                        livre.getAllBooks();
                    break;
                case 7:
                    EmprintView.emprintBook();
                    break;

                default:
                    System.out.println("Invalid choice");
            }



       }











        /*Dbconnection.getConnection();
        Auteur auteur = new Auteur(1, "victor", "victor@gmail.com");

        Bibliothecaire bibliotecaire = new Bibliothecaire(1, "hind","hind@gmail.com");

        Livre nouveauLivre = new Livre(1,"1123","1234567890",10,0,0,auteur,10,bibliotecaire);

        nouveauLivre.ajouterLivre(nouveauLivre);*/



        /*Auteur auteur = new Auteur(1, "victor", "victor@gmail.com");

        Bibliothecaire bibliotecaire = new Bibliothecaire(1, "hind","hind@gmail.com");

        Livre nouveauLivre = new Livre(7,"1123","testibnupdated",10,0,0,auteur,10,bibliotecaire);

        nouveauLivre.updateLivre(nouveauLivre);*/


    }

}