package org.example.tableaualeatoire;

import java.util.Random;

public class TableauAleatoire {
    public static void main(String[] args) {
        Random random = new Random();

        int[] tableau = new int[10];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(100) + 1;
        }
        System.out.println("Les éléments du tableau sont :");
        for (int i = 0; i < tableau.length; i++) {
            System.out.println(tableau[i]);
        }
    }
}
