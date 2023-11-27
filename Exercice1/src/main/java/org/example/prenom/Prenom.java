package org.example.prenom;

import java.util.Scanner;

public class Prenom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quel est votre prénom ? ");
        String prenom = scanner.nextLine();
        scanner.close();

        System.out.println("Bonjour, " + prenom + " !");
    }
}
