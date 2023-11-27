package org.example.recherchedanstableau;

import java.util.Scanner;

public class RechercheDansTableau {
    public static void main(String[] args) {

        int[] tableau = {10, 20, 30, 40, 50, 60, 70, 80};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un entier à rechercher dans le tableau : ");
        int entierRecherche = scanner.nextInt();
        boolean estPresent = false;
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] == entierRecherche) {
                estPresent = true;
                break;
            }
        }
        if (estPresent) {
            System.out.println("L'entier est présent dans le tableau.");
        } else {
            System.out.println("L'entier n'est pas présent dans le tableau.");
        }
    }
}
