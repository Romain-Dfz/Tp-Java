package org.example.valeurmaxmatrice;

public class ValeurMaxMatrice {
    public static void main(String[] args) {
        int[] matrice = {45, 23, 34, 56, 30, 67, 75, 21, 52, 59, 89, 34, 19, 19, 15, 1, 78, 90, 48, 42};

        int valeurMax = trouverValeurMax(matrice);

        System.out.println("La valeur maximale dans la matrice est : " + valeurMax);
    }
    public static int trouverValeurMax(int[] matrice) {
        if (matrice.length == 0) {
            throw new IllegalArgumentException("La matrice ne peut pas être vide.");
        }
        int valeurMax = matrice[0];
        for (int i = 1; i < matrice.length; i++) {
            if (matrice[i] > valeurMax) {
                valeurMax = matrice[i];
            }
        }
        return valeurMax;
    }
}
