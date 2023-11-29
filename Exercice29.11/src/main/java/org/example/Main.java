package org.example;

public class Main {
    public static void main(String[] args) {
        Magasin magasin = new Magasin();

        Ramette ramette1 = new Ramette("R001", "Ramette A4", 1.72, 80);
        Stylo stylo1 = new Stylo("S001", "Stylo bleu", 5, "Rouge");

        magasin.ajouterArticle(ramette1);
        magasin.ajouterArticle(stylo1);

        Facture facture1 = new Facture("Client1", "2023-11-29");
        facture1.ajouterLigne(ramette1, 3);
        facture1.ajouterLigne(stylo1, 2);

        for (LigneFacture ligne : facture1.getLignes()) {
            if (ligne != null) {
                ligne.afficherLigne();
            }
        }

        System.out.println("Prix total de la facture : " + facture1.getPrixTotal() + " €" );
    }
}
