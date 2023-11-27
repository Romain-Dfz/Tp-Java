package org.example.nombreentier;
import java.util.Scanner;

public class NombreEntier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nombre;

        do {
            System.out.print("Veuillez entrer un nombre entre 1 et 3 : ");
            nombre = scanner.nextInt();
            if (nombre >= 1 && nombre <= 3) {
                break;
            } else {
                System.out.println("Réponse non valide. Veuillez entrer un nombre entre 1 et 3.");
            }
        } while (true);

        System.out.println("La réponse est valide : " + nombre);
        scanner.close();
    }
}
