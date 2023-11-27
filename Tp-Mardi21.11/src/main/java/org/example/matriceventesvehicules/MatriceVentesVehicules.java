package org.example.matriceventesvehicules;

import java.util.Scanner;

public class MatriceVentesVehicules {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de vendeurs : ");
        int nombreVendeurs = scanner.nextInt();

        System.out.print("Nombre de marques de véhicules : ");
        int nombreMarques = scanner.nextInt();

        int[][] ventes = new int[nombreVendeurs][nombreMarques];

        for (int i = 0; i < nombreVendeurs; i++) {
            System.out.println("Saisie des ventes pour le vendeur " + (i + 1) + ":");
            for (int j = 0; j < nombreMarques; j++) {
                System.out.print("Ventes pour la marque " + (j + 1) + ": ");
                ventes[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nMatrice des ventes :");
        afficherMatrice(ventes);

        int[] totalVentesVendeur = new int[nombreVendeurs];
        for (int i = 0; i < nombreVendeurs; i++) {
            for (int j = 0; j < nombreMarques; j++) {
                totalVentesVendeur[i] += ventes[i][j];
            }
        }
        int[] totalVentesMarque = new int[nombreMarques];
        for (int j = 0; j < nombreMarques; j++) {
            for (int i = 0; i < nombreVendeurs; i++) {
                totalVentesMarque[j] += ventes[i][j];
            }
        }
        System.out.println("\nTotal des ventes par vendeur :");
        for (int i = 0; i < nombreVendeurs; i++) {
            System.out.println("Vendeur " + (i + 1) + ": " + totalVentesVendeur[i] + " véhicules");
        }
        System.out.println("\nTotal des ventes par marque :");
        for (int j = 0; j < nombreMarques; j++) {
            System.out.println("Marque " + (j + 1) + ": " + totalVentesMarque[j] + " véhicules");
        }
    }

    public static void afficherMatrice(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
}
