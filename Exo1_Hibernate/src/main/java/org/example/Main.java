package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez la date de début (format: yyyy-MM-dd HH:mm:ss): ");
        String startDateString = scanner.nextLine();
        String startDate = String.valueOf(parseDate(startDateString));

        System.out.println("Entrez la date de fin (format: yyyy-MM-dd HH:mm:ss): ");
        String endDateString = scanner.nextLine();
        Date endDate = parseDate(endDateString);

        ProduitDAO produitDAO = new ProduitDAO();

        List<Produit> produitsBetweenDates = produitDAO.getProduitsBetweenDates(startDate, String.valueOf(endDate));
        displayProducts(produitsBetweenDates);

        System.out.println("Entrez la valeur de stock maximale : ");
        int maxStockValue = scanner.nextInt();
        List<Object[]> productsInfoByStock = produitDAO.getProductsInfoByStockLessThan(maxStockValue);
        displayProductInfo(productsInfoByStock);
        produitDAO.shutdown();
    }
    private static void displayProducts(List<Produit> produits) {
        System.out.println("Produits entre les dates :");
        if (produits != null && !produits.isEmpty()) {
            for (Produit produit : produits) {
                System.out.println("Produit : " + produit);
            }
        } else {
            System.out.println("Aucun produit trouvé.");
        }
    }

    private static void displayProductInfo(List<Object[]> productsInfo) {
        System.out.println("Informations des produits :");
        if (productsInfo != null && !productsInfo.isEmpty()) {
            for (Object[] productInfo : productsInfo) {
                System.out.println("ID : " + productInfo[0] + ", Reference : " + productInfo[1]);
            }
        } else {
            System.out.println("Aucune information de produit trouvée.");
        }
    }

    private static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Erreur lors de la conversion de la date.", e);
        }
    }
}
