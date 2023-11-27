package org.example.rectangleprogram;

import java.util.Scanner;

public class RectangleProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la hauteur du rectangle : ");
        int hauteur = scanner.nextInt();
        System.out.print("Entrez la largeur du rectangle : ");
        int largeur = scanner.nextInt();
        drawRectangle(hauteur, largeur);
    }
    public static void drawRectangle(int hauteur, int largeur) {
        if (hauteur <= 0 || largeur <= 0) {
            System.out.println("La hauteur et la largeur doivent être supérieures à zéro.");
            return;
        }

        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (i == 0 || i == hauteur - 1 || j == 0 || j == largeur - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
