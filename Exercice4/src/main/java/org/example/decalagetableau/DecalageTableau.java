package org.example.decalagetableau;

public class DecalageTableau {
    public static void main(String[] args) {
        int[] tableau = {1, 2, 3, 4, 5};

        System.out.println("Tableau avant le décalage :");
        afficherTableau(tableau);
        decalerTableauADroite(tableau);

        System.out.println("Tableau après le décalage :");
        afficherTableau(tableau);
    }
    private static void decalerTableauADroite(int[] tableau) {
        int derniereValeur = tableau[tableau.length - 1];

        for (int i = tableau.length - 1; i > 0; i--) {
            tableau[i] = tableau[i - 1];
        }
        tableau[0] = derniereValeur;
    }

    private static void afficherTableau(int[] tableau) {
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();
    }
}
