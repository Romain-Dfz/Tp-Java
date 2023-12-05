package org.example;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Produit> produits = Arrays.asList(
                new Produit("Ordinateur portable", 1200.00, "Électronique"),
                new Produit("Smartphone", 800.00, "Électronique"),
                new Produit("Livre", 20.00, "Littérature"),
                new Produit("Vélo", 300.00, "Sport"),
                new Produit("Table", 255.00, "Meuble" ),
                new Produit("Ordinateur fixe", 2137.00, "Électronique" )
        );

        System.out.println("Produits dont le prix est inférieur à 500.00€ :");
        List<Produit> produitsPrixInferieur = FiltrageProduits.filtrerProduits(produits, p -> p.getPrix() < 500.00);
        afficherProduits(produitsPrixInferieur);

        System.out.println("\nProduits de la catégorie 'Électronique' :");
        List<Produit> produitsElectronique = FiltrageProduits.filtrerProduits(produits, p -> p.getCategorie().equals("Électronique"));
        afficherProduits(produitsElectronique);

    }
    private static void afficherProduits(List<Produit> produits) {
        for (Produit produit : produits) {
            System.out.println(produit.getNom() + " - " + produit.getPrix() + "€ - " + produit.getCategorie());
        }
    }
}
