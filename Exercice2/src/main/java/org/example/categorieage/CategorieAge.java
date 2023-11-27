package org.example.categorieage;

import java.util.Scanner;

public class CategorieAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer l'âge de l'enfant : ");
        int age = scanner.nextInt();
        scanner.close();

        if (age >= 6 && age <= 7) {
            System.out.println("Catégorie : Poussin.");
        } else if (age >= 8 && age <=9) {
            System.out.println("Ctaégorie : Pupille.");
        } else if (age >= 10 && age <=11) {
            System.out.println("Catégorie : Minime.");
        } else if (age >= 12 && age <=17) {
            System.out.println("Catégorie : Cadet.");
        } else if (age >= 18) {
            System.out.println("Catégorie : Sénior.");
        } else {
            System.out.println("Rentre pas dans une catégorie.");
        }
    }
}
