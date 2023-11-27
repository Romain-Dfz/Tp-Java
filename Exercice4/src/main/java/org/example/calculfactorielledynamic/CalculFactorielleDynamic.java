package org.example.calculfactorielledynamic;

import java.util.Scanner;

public class CalculFactorielleDynamic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long factorielle = 1;
        System.out.print("Veuillez entrer un nombre (ou un zéro pour arrêter) : ");
        int nombre = scanner.nextInt();
        while (nombre != 0) {
            factorielle *= nombre;
            System.out.print("Veuillez entrer un nombre (ou un zéro pour arrêter) : ");
            nombre = scanner.nextInt();
        }
        scanner.close();
        System.out.println("La factorielle des nombres saisis est : " + factorielle);
    }
}

