package org.example.verificationpairs;

import java.util.Scanner;

public class VerificationPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la taille du tableau : ");
        int taille = scanner.nextInt();
        int[] tableau = new int[taille];
        System.out.println("Entrez les éléments du tableau :");
        for (int i = 0; i < taille; i++) {
            System.out.print("Élément " + (i + 1) + " : ");
            tableau[i] = scanner.nextInt();
        }
        boolean tousPairs = true;
        for (int i = 0; i < taille; i++) {
            if (tableau[i] % 2 != 0) {
                tousPairs = false;
                break;
            }
        }
        if (tousPairs) {
            System.out.println("Tous les éléments sont pairs.");
        } else {
            System.out.println("Au moins un élément est impair.");
        }
    }
}
