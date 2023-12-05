package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le configurateur de pizza!");

        String taille = obtenirChoixUtilisateur(scanner, "Étape 1 : Choisissez la taille de la pizza (Petite, Moyenne, Grande): ", Arrays.asList("Petite", "Moyenne", "Grande"));

        String typeDePate = obtenirChoixUtilisateur(scanner, "Étape 2 : Choisissez le type de pâte (Classique, Fine, Épaisse): ", Arrays.asList("Classique", "Fine", "Épaisse"));

        String fromage = obtenirChoixUtilisateur(scanner, "Étape 3 : Choisissez le fromage (Mozzarella, Cheddar, Sans fromage): ", Arrays.asList("Mozzarella", "Cheddar", "Sans fromage"));

        List<String> garnitures = obtenirGarnitures(scanner);

        String sauce = obtenirChoixUtilisateur(scanner, "Étape 5 : Choisissez la sauce (Tomate, Crème, Barbecue): ", Arrays.asList("Tomate", "Crème", "Barbecue"));

        Pizza pizza = new Pizza.Builder()
                .taille(taille)
                .typeDePate(typeDePate)
                .fromage(fromage)
                .garnitures(garnitures)
                .sauce(sauce)
                .build();

        System.out.println("\nVous avez créé la pizza suivante :");
        System.out.println("Taille: " + pizza.getTaille());
        System.out.println("Pâte: " + pizza.getTypeDePate());
        System.out.println("Fromage: " + pizza.getFromage());
        System.out.println("Garnitures: " + pizza.getGarnitures());
        System.out.println("Sauce: " + pizza.getSauce());
    }

    private static String obtenirChoixUtilisateur(Scanner scanner, String message, List<String> options) {
        String choixUtilisateur;
        do {
            System.out.println(message);
            choixUtilisateur = scanner.nextLine();
        } while (!options.contains(choixUtilisateur));
        return choixUtilisateur;
    }

    private static List<String> obtenirGarnitures(Scanner scanner) {
        List<String> garnitures;
        do {
            System.out.println("Étape 4 : Ajoutez des garnitures (séparées par des virgules): Jambon, Champignons, Pepperoni, Poivrons): ");
            String garnituresInput = scanner.nextLine();
            String[] garnitureArray = garnituresInput.split(", ");
            garnitures = Arrays.asList(garnitureArray);

            if (garnitures.stream().anyMatch(g -> !Arrays.asList("Jambon", "Champignons", "Pepperoni", "Poivrons").contains(g))) {
                System.out.println("Erreur : Certaines garnitures ne sont pas valides. Veuillez réessayer.");
            }
        } while (garnitures.stream().anyMatch(g -> !Arrays.asList("Jambon", "Champignons", "Pepperoni", "Poivrons").contains(g)));

        return garnitures;
    }
}
