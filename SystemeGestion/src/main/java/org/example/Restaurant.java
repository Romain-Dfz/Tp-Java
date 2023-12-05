package org.example;
import java.util.Scanner;

public class Restaurant {
    private CuisineFactory cuisineFactory;

    public Restaurant(CuisineFactory cuisineFactory) {
        this.cuisineFactory = cuisineFactory;
    }

    public void prepareMeal() {
        FoodTypes.Ingredient ingredient = cuisineFactory.createIngredient();
        FoodTypes.CookingUtensil utensil = cuisineFactory.createUtensil();
        FoodTypes.Dish dish = cuisineFactory.createDish();

        System.out.println("Préparation d'un repas :");
        ingredient.prepare();
        utensil.use();
        dish.serve();
    }

    public void setCuisineFactory(CuisineFactory cuisineFactory) {
        this.cuisineFactory = cuisineFactory;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant(null);

        while (true) {
            System.out.println("Choisissez un type de cuisine :");
            System.out.println("1. Italienne");
            System.out.println("2. Japonaise");
            System.out.println("3. Mexicaine");
            System.out.println("4. Quitter");

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un chiffre valide.");
                scanner.next();
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    restaurant.setCuisineFactory(new ItalianCuisineFactory());
                    restaurant.prepareMeal();
                    break;
                case 2:
                    restaurant.setCuisineFactory(new JapaneseCuisineFactory());
                    restaurant.prepareMeal();
                    break;
                case 3:
                    restaurant.setCuisineFactory(new MexicanCuisineFactory());
                    restaurant.prepareMeal();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
    }
}
