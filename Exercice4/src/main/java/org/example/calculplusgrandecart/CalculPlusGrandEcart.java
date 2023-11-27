package org.example.calculplusgrandecart;

public class CalculPlusGrandEcart {
    public static void main(String[] args) {
        int[] tableau = {2, 9, 5, 1, 7, 3, 8, 6, 4};

        int maxEcart = calculerPlusGrandEcart(tableau);

        System.out.println("Le plus grand écart dans le tableau est : " + maxEcart);
    }
    private static int calculerPlusGrandEcart(int[] tableau) {
        int maxEcart = 0;
        for (int i = 0; i < tableau.length - 1; i++) {
            for (int j = i + 1; j < tableau.length; j++) {
                int ecart = Math.abs(tableau[i] - tableau[j]);

                if (ecart > maxEcart) {
                    maxEcart = ecart;
                }
            }
        }

        return maxEcart;
    }
}
