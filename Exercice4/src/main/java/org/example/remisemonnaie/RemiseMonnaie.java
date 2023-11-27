package org.example.remisemonnaie;
import java.util.Scanner;

public class RemiseMonnaie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sommeDue = 0;

        int prixAchat;
        do {
            System.out.print("Entrez le prix de l'achat (ou 0 pour terminer) : ");

            prixAchat = scanner.nextInt();

            sommeDue += prixAchat;
        } while (prixAchat != 0);

        System.out.println("La somme due est : " + sommeDue + " Euros.");

        System.out.print("Entrez la somme que vous payez : ");

        int sommePayee = scanner.nextInt();

        int monnaie = sommePayee - sommeDue;

        while (monnaie >= 10) {
            System.out.println("10 Euros");
            monnaie -= 10;
        }

        while (monnaie >= 5) {
            System.out.println("5 Euros");
            monnaie -= 5;
        }

        while (monnaie >= 1) {
            System.out.println("1 Euro");
            monnaie -= 1;
        }
        scanner.close();
    }
}
