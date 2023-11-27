package org.example.nombreoccurences;

import java.util.Scanner;

public class NombreOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la taille du tableau : ");
        int N = scanner.nextInt();
        int[] tableau = new int[N];
        for (int i = 0; i < N; i++) {
            tableau[i] = (int) (Math.random() * 10);
        }

        System.out.print("Entrez la valeur à rechercher : ");
        int valeurRecherche = scanner.nextInt();

        int occurrences = trouverNombreOccurrences(tableau, valeurRecherche);

        System.out.println("Le nombre d'occurrences de la valeur " + valeurRecherche + " dans le tableau est : " + occurrences);
    }
    private static int trouverNombreOccurrences(int[] tableau, int valeurRecherche) {
        int occurrences = 0;
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] == valeurRecherche) {
                occurrences++;
            }
        }

        return occurrences;
    }
}
