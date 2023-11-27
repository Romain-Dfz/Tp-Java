package org.example.prixphotocopies;

import java.util.Scanner;

public class PrixPhotocopies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer le nombre de photocopies : ");
        int nombrePhotocopies = scanner.nextInt();
        scanner.close();
        double prixAPayer;

        if (nombrePhotocopies < 10) {
            prixAPayer = nombrePhotocopies * 0.15;
        } else if (nombrePhotocopies > 10 && nombrePhotocopies <= 20) {
            prixAPayer = nombrePhotocopies * 0.10;
        } else {
            prixAPayer = nombrePhotocopies * 0.5;
        }
    }
}