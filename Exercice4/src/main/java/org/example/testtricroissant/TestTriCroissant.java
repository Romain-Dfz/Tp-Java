package org.example.testtricroissant;

public class TestTriCroissant {
    public static void main(String[] args) {
        int[] tableau1 = {1, 2, 3, 4, 5};
        int[] tableau2 = {5, 3, 7, 1, 8};

        if (estTableauTrieCroissant(tableau1)) {
            System.out.println("Le tableau 1 est trié par ordre croissant.");
        } else {
            System.out.println("Le tableau 1 n'est pas trié par ordre croissant.");
        }

        if (estTableauTrieCroissant(tableau2)) {
            System.out.println("Le tableau 2 est trié par ordre croissant.");
        } else {
            System.out.println("Le tableau 2 n'est pas trié par ordre croissant.");
        }
    }

    private static boolean estTableauTrieCroissant(int[] tableau) {
        for (int i = 0; i < tableau.length - 1; i++) {
            if (tableau[i] > tableau[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
