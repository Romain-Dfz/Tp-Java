package org.example.inversiontableau;

public class InversionTableau {
    public static void main(String[] args) {
        int[] tableau = {1, 2, 3, 4, 5};

        System.out.println("Tableau avant l'inversion :");
        afficherTableau(tableau);
        inverserTableau(tableau);
        System.out.println("Tableau après l'inversion :");
        afficherTableau(tableau);
    }
    private static void inverserTableau(int[] tableau) {
        int debut = 0;
        int fin = tableau.length - 1;

        while (debut < fin) {
            int temp = tableau[debut];
            tableau[debut] = tableau[fin];
            tableau[fin] = temp;
            debut++;
            fin--;
        }
    }
    private static void afficherTableau(int[] tableau) {
        for (int valeur : tableau) {
            System.out.print(valeur + " ");
        }
        System.out.println();
    }
}

