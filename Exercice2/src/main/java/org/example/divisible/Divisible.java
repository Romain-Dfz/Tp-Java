package org.example.divisible;

import java.util.Scanner;

public class Divisible {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer un nombre entier : ");
        int nombre = scanner.nextInt();
        scanner.close();

        if (nombre % 3 == 0) {
            System.out.println("Le nombre est divible par 3.");
        } else {
            System.out.println("Le nombre n'est pas divible par 3");
        }
    }
}
