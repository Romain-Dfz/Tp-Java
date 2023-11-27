package org.example.produitspositifnegatif;
import java.util.Scanner;

public class ProduitsPositifNegatif {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer le premier nombre : ");
        double premierNombre = scanner.nextDouble();
        System.out.print("Veuillez entrer le deuxième nombre : ");
        double deuxiemeNombre = scanner.nextDouble();
        scanner.close();

        if ((premierNombre > 0 && deuxiemeNombre > 0) || (premierNombre < 0 && deuxiemeNombre < 0)) {
            System.out.println("Le produit est positif.");
        } else {
            System.out.println("Le produit est négatif.");
        }
    }
}

