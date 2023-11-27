package org.example.positifnegatif;
import java.util.Scanner;

public class PositifNegatif {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer un nombre : ");
        double nombre = scanner.nextDouble();
        scanner.close();

        if (nombre > 0) {
            System.out.println("Le nombre est positif.");
        } else if (nombre < 0) {
            System.out.println("Le nombre est négatif.");
        } else {
            System.out.println("Le nombre est égal à zéro.");
        }
    }
}
