package org.example.triparselection;

public class TriParSelection {
    public static void main(String[] args) {
        int[] tableau = {64, 25, 12, 22, 11};

        System.out.println("Tableau avant le tri par sélection :");
        afficherTableau(tableau);

        triParSelection(tableau);

        System.out.println("Tableau après le tri par sélection :");
        afficherTableau(tableau);
    }
    private static void triParSelection(int[] tableau) {
        int n = tableau.length;
        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (tableau[j] < tableau[indexMin]) {
                    indexMin = j;
                }
            }
            int temp = tableau[i];
            tableau[i] = tableau[indexMin];
            tableau[indexMin] = temp;
        }
    }
    private static void afficherTableau(int[] tableau) {
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();
    }
}

