package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HibernateUtil.getSessionFactory();

        Produit produit = new Produit();
        produit.setDateAchat(new Date());
        produit.setMarque("Marque XYZ");
        produit.setPrix(120.0);
        produit.setReference("REF123");
        produit.setStock(50);

        ProduitDAO.createProduit(produit);
        System.out.println("Produit ajouté avec succès.");
        System.out.println("\nListe de tous les produits :");
        List<Produit> allProducts = ProduitDAO.getAllProduits();
        displayProducts(allProducts);

        System.out.println("\nListe des produits dont le prix est supérieur à 100 euros :");
        List<Produit> expensiveProducts = ProduitDAO.getProductsByPriceGreaterThan(100.0);
        displayProducts(expensiveProducts);

        System.out.println("\nListe des produits achetés entre deux dates :");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.print("Entrez la date de début (format YYYY-MM-DD) : ");
            Date startDate = sdf.parse(scanner.nextLine());
            System.out.print("Entrez la date de fin (format YYYY-MM-DD) : ");
            Date endDate = sdf.parse(scanner.nextLine());

            List<Produit> productsBetweenDates = ProduitDAO.getProductsBetweenDates(startDate, endDate);
            displayProducts(productsBetweenDates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HibernateUtil.shutdown();
        scanner.close();
    }
    private static void displayProducts(List<Produit> produits) {
        for (Produit produit : produits) {
            System.out.println(produit);
        }
        System.out.println();
    }
}
