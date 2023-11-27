package org.example.plusgrandelement;

import java.util.Random;

public class PlusGrandElement {
    public static void main(String[] args) {

        Random random = new Random();
        int[] tableau = new int[10];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(100) + 1;
        }

        System.out.println("Les éléments du tableau sont :");
        afficherTableau(tableau);

        int plusGrandElement = trouverPlusGrandElement(tableau);

        System.out.println("Le plus grand élément du tableau est : " + plusGrandElement);
    }
    private static void afficherTableau(int[] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i] + " ");
        }
        System.out.println();
    }
    private static int trouverPlusGrandElement(int[] tableau) {
        int max = tableau[0]; // Supposons que le premier élément est le plus grand initialement

        for (int i = 1; i < tableau.length; i++) {
            if (tableau[i] > max) {
                max = tableau[i];
            }
        }
        return max;
    }
}

