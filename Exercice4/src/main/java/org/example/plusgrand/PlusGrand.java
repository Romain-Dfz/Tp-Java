package org.example.plusgrand;

import java.util.Scanner;

public class PlusGrand {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plusGrand = Integer.MIN_VALUE;
        int positionPlusGrand = 0;

        for (int i = 1; i <= 20; i++) {
            System.out.print("Entrez le nombre numéro " + i + " : ");

            int nombre = scanner.nextInt();

            if (nombre > plusGrand) {
                plusGrand = nombre;
                positionPlusGrand = i;
            }
        }
        scanner.close();
        System.out.println("Le plus grand de ces nombres est : " + plusGrand);
        System.out.println("C'était le nombre numéro " + positionPlusGrand);
    }
}
