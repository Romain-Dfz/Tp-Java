package org.example.calculttc;
import java.util.Scanner;

public class CalculTTC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le prix hors taxe de l'article : ");
        double prixHT = scanner.nextDouble();

        System.out.print("Entrez le nombre d'articles : ");
        int nombreArticles = scanner.nextInt();

        System.out.print("Entrez le taux de TVA (en pourcentage) : ");
        double tauxTVA = scanner.nextDouble();

        scanner.close();

        double tauxTVAEnDecimal = tauxTVA / 100.0;
        double prixTTC = prixHT * (1 + tauxTVAEnDecimal) * nombreArticles;

        System.out.println("\nRécapitulatif de l'achat :");
        System.out.println("Prix HT par article : " + prixHT + " euros");
        System.out.println("Nombre d'articles : " + nombreArticles);
        System.out.println("Taux de TVA : " + tauxTVA + "%");
        System.out.println("Prix total TTC : " + prixTTC + " euros");
    }
}
