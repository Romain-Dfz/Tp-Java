package org.example.matricerectangulaire;

public class MatriceRectangulaire {
    public static void main(String[] args) {
        int hauteur = 5;
        int largeur = 4;
        int[][] matrice = new int[hauteur][largeur];
        int[] valeurs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int index = 0;
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (index < valeurs.length) {
                    matrice[i][j] = valeurs[index];
                    index++;
                }
            }
        }
        afficherMatrice(matrice);

        int somme = calculerSomme(matrice);
        int produitTotal = calculerProduitTotal(matrice);
        double moyenne = calculerMoyenne(matrice);
        System.out.println("Somme : " + somme);
        System.out.println("Produit total : " + produitTotal);
        System.out.println("Moyenne : " + moyenne);
    }
    public static void afficherMatrice(int[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int calculerSomme(int[][] matrice) {
        int somme = 0;
        for (int[] ligne : matrice) {
            for (int valeur : ligne) {
                somme += valeur;
            }

        }
        return somme;
    }
    public static int calculerProduitTotal(int[][] matrice) {
        int produitTotal = 1;
        for (int[] ligne : matrice) {
            for (int valeur : ligne) {
                produitTotal *= valeur;
            }
        }
        return produitTotal;
    }
    public static double calculerMoyenne(int[][] matrice) {
        int somme = calculerSomme(matrice);
        int nombreElements = matrice.length * matrice[0].length;
        return (double) somme / nombreElements;
    }
}
