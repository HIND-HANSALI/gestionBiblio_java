package org.example.console;

import helper.Printer;
import helper.Scanner;
import org.example.Emprunteur;
import org.example.Livre;
import org.example.model.LivreEmprinteur;

public class EmprintView {
    private static Emprunteur emprunteur = new Emprunteur();
    private static Livre livre = new Livre();
    private  static LivreEmprinteur livreEmprinteur = new LivreEmprinteur();

    public static void emprintBook() {
        while (true) {
            Printer.print("Enter your CIN: ");
            emprunteur.setCin(Scanner.scan());
            emprunteur = emprunteur.getEmprunteurByCin(emprunteur.getCin());
            if (emprunteur == null) {
                Printer.print("This CIN was not found.");
            } else {
                break;
            }
        }

        while (true) {
            Printer.print("Enter the book ISBN: ");
            livre.setNumIsbn(Scanner.scan());
            livre = livre.getLivreBySbn(livre.getNumIsbn());
            if (livre == null) {
                Printer.print("This ISBN was not found.");
            } else {
                break;
            }
        }
        livreEmprinteur.setLivre_id(livre.getId());
        livreEmprinteur.setEmprunteur_id(emprunteur.getId());

        Printer.print("enter the quantity");
        livreEmprinteur.setQuanity(Integer.parseInt(Scanner.scan()));





    }
}
