package org.example;
import java.util.ArrayList;
import java.util.List;

public class FiltrageProduits {

    public static List<Produit> filtrerProduits(List<Produit> produits, CritereFiltrage critere) {
        List<Produit> produitsFiltres = new ArrayList<>();
        for (Produit produit : produits) {
            if (critere.test(produit)) {
                produitsFiltres.add(produit);
            }
        }
        return produitsFiltres;
    }
}
