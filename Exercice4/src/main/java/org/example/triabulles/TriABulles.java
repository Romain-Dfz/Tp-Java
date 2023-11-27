package org.example.triabulles;

public class TriABulles {
    public static void main(String[] args) {
        int[] tableau = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Tableau avant le tri à bulles :");
        afficherTableau(tableau);

        triABulles(tableau);

        System.out.println("Tableau après le tri à bulles :");
        afficherTableau(tableau);
    }

    private static void triABulles(int[] tableau) {
        int n = tableau.length;
        boolean echangeEffectue;

        do {
            echangeEffectue = false;
            for (int i = 0; i < n - 1; i++) {
                if (tableau[i] > tableau[i + 1]) {
                    int temp = tableau[i];
                    tableau[i] = tableau[i + 1];
                    tableau[i + 1] = temp;
                    echangeEffectue = true;
                }
            }
        } while (echangeEffectue);
    }

    private static void afficherTableau(int[] tableau) {
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();
    }
}
