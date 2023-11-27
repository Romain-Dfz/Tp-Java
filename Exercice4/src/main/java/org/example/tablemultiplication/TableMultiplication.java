package org.example.tablemultiplication;

import java.util.Scanner;

public class TableMultiplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer un nombre de départ : ");
        int nombreDepart = scanner.nextInt();
        scanner.close();
        System.out.println("Table de " + nombreDepart + " :");

        for (int i = 1; i <= 10; i++) {
            int produit = nombreDepart * i;
            System.out.println(nombreDepart + " x " + i + " = " + produit);
        }
    }
}
