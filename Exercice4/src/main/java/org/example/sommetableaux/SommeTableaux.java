package org.example.sommetableaux;

import java.util.Random;

public class SommeTableaux {
    public static void main(String[] args) {
        Random random = new Random();
        int taille = 5;

        int[] tableau1 = new int[taille];
        int[] tableau2 = new int[taille];
        for (int i = 0; i < taille; i++) {
            tableau1[i] = random.nextInt(100) + 1;
            tableau2[i] = random.nextInt(100) + 1;
        }

        System.out.println("Tableau 1 :");
        afficherTableau(tableau1);

        System.out.println("Tableau 2 :");
        afficherTableau(tableau2);

        int somme = calculerSomme(tableau1, tableau2);
        System.out.println("La somme des éléments des deux tableaux est : " + somme);
    }
    private static void afficherTableau(int[] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i] + " ");
        }
        System.out.println();
    }
    private static int calculerSomme(int[] tableau1, int[] tableau2) {
        int somme = 0;
        for (int i = 0; i < tableau1.length; i++) {
            somme += tableau1[i] + tableau2[i];
        }
        return somme;
    }
}
