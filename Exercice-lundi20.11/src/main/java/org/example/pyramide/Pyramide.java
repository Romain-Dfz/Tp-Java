package org.example.pyramide;

import java.util.Scanner;

public class Pyramide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la hauteur de la pyramide : ");
        int hauteurPyramide = scanner.nextInt();
        dessinerPyramide(hauteurPyramide);
    }
    static void dessinerPyramide(int hauteur) {
        for (int i = 1; i <= hauteur; i++) {
            for (int j = 0; j < hauteur - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
