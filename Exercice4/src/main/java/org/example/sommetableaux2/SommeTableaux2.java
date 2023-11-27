package org.example.sommetableaux2;

import java.util.Arrays;

public class SommeTableaux2 {
    public static void main(String[] args) {
        int[][] t1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] t2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] somme = sommeTableaux(t1, t2);

        if (somme != null) {
            System.out.println("Somme des tableaux :");
            afficherTableau(somme);
        } else {
            System.out.println("Les tableaux ne sont pas réguliers ou n'ont pas la même dimension.");
        }
    }
    private static int[][] sommeTableaux(int[][] t1, int[][] t2) {
        if (t1.length != t2.length) {
            return null;
        }

        for (int i = 0; i < t1.length; i++) {
            if (t1[i].length != t2[i].length) {
                return null;
            }
        }
        int[][] somme = new int[t1.length][t1[0].length];

        for (int i = 0; i < t1.length; i++) {
            for (int j = 0; j < t1[i].length; j++) {
                somme[i][j] = t1[i][j] + t2[i][j];
            }
        }

        return somme;
    }
    private static void afficherTableau(int[][] tableau) {
        for (int[] ligne : tableau) {
            System.out.println(Arrays.toString(ligne));
        }
    }
}

