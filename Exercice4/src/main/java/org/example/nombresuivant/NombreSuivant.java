package org.example.nombresuivant;

import java.util.Scanner;

public class NombreSuivant {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer un nombre de départ : ");
        int nombreDepart = scanner.nextInt();
        scanner.close();

        System.out.println("Les diw nombres suivants sont :");
        for (int i = 1; i <= 10; i++) {
            int nombreSuivant = nombreDepart + i;
            System.out.println(nombreSuivant);
        }

    }
}