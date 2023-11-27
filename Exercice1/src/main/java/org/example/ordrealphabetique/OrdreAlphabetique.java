package org.example.ordrealphabetique;
import java.util.Scanner;

public class OrdreAlphabetique {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le premier nom : ");
        String premierNom = scanner.nextLine();
        System.out.print("Veuillez entrer le deuxième nom : ");
        String deuxiemeNom = scanner.nextLine();
        System.out.print("Veuillez entrer le troisième nom : ");
        String troisiemeNom = scanner.nextLine();

        scanner.close();

        if (premierNom.compareToIgnoreCase(deuxiemeNom) <= 0 &&
                deuxiemeNom.compareToIgnoreCase(troisiemeNom) <= 0) {
            System.out.println("Les noms sont rangés dans l'ordre alphabétique.");
        } else {
            System.out.println("Les noms ne sont pas rangés dans l'ordre alphabétique.");
        }
    }
}
