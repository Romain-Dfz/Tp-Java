package org.example.sommeentiers;

import java.util.Scanner;

public class SommeEntiers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer un nombre de départ : ");
        int nombreDepart = scanner.nextInt();
        scanner.close();
        int somme = 0;
        for (int i = 1; i <= nombreDepart; i++) {
            somme += i;
        }
        System.out.println("La somme des entiers jusqu'à " + nombreDepart + " est " + somme);
    }
}
