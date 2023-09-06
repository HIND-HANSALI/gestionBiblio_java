package org.example;

import database.Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
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
            System.out.println("3. Delete Book");
            System.out.println("4. Borrow Book");
           System.out.println("5. Return Book");
            System.out.println("6. List Books");
           System.out.println("7. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("-----------------------------------------");
            switch (choice) {
               case 1:
                   System.out.println("1. Insert New Book Informations");

                   System.out.print("Enter the id book: ");
                   int id = scanner.nextInt();
                   scanner.nextLine();

                   System.out.print("Enter the title of the book: ");
                   String title = scanner.nextLine();


                   System.out.println("Enter the author name of the book:");
                   String author_name = scanner.nextLine();
                   Auteur auteur = new Auteur(1,author_name);

                   System.out.println("Enter the bibliothecaire name of the book:");
                   String librarian_name = scanner.nextLine();
                   Bibliothecaire bibliotecaire = new Bibliothecaire(1,librarian_name);

                   System.out.println("Enter book ISBN:");
                   String numIsbn = scanner.nextLine();

                   System.out.println("Enter book QuantityTotal:");
                   int quantityTotal = scanner.nextInt();

                   System.out.println("Enter book quantity Lost:");
                   int quantityLost = scanner.nextInt();

                   System.out.println("Enter book quantity Reserved:");
                   int quantityReserved = scanner.nextInt();
                   System.out.println("Enter book quantity Available:");
                   int quantityAvailable = scanner.nextInt();



                   Livre nouveauLivre = new Livre(id,title,numIsbn ,quantityTotal,quantityLost,quantityReserved,auteur,quantityAvailable,bibliotecaire);
                   livre.ajouterLivre(nouveauLivre);
                   break;

                case 7:
                    // Exit the program
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }



       }











        /*Dbconnection.getConnection();
        Auteur auteur = new Auteur(1, "victor", "victor@gmail.com");

        Bibliothecaire bibliotecaire = new Bibliothecaire(1, "hind","hind@gmail.com");

        Livre nouveauLivre = new Livre(1,"1123","1234567890",10,0,0,auteur,10,bibliotecaire);

        nouveauLivre.ajouterLivre(nouveauLivre);*/




    }

}