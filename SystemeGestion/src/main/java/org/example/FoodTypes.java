package org.example;
public class FoodTypes {
    public static abstract class Ingredient {
        public abstract void prepare();
    }

    public static abstract class CookingUtensil {
        public abstract void use();
    }

    public static abstract class Dish {
        public abstract void serve();
    }

    public static class ItalianIngredient extends Ingredient {
        @Override
        public void prepare() {
            System.out.println("Préparation de l'ingrédient italien");
        }
    }

    public static class JapaneseIngredient extends Ingredient {
        @Override
        public void prepare() {
            System.out.println("Préparation de l'ingrédient japonais");
        }
    }

    public static class MexicanIngredient extends Ingredient {
        @Override
        public void prepare() {
            System.out.println("Préparation de l'ingrédient mexicain");
        }
    }

    public static class ItalianUtensil extends CookingUtensil {
        @Override
        public void use() {
            System.out.println("Utilisation de l'ustensile italien");
        }
    }

    public static class JapaneseUtensil extends CookingUtensil {
        @Override
        public void use() {
            System.out.println("Utilisation de l'ustensile japonais");
        }
    }

    public static class MexicanUtensil extends CookingUtensil {
        @Override
        public void use() {
            System.out.println("Utilisation de l'ustensile mexicain");
        }
    }

    public static class ItalianDish extends Dish {
        @Override
        public void serve() {
            System.out.println("Service du plat italien");
        }
    }

    public static class JapaneseDish extends Dish {
        @Override
        public void serve() {
            System.out.println("Service du plat japonais");
        }
    }

    public static class MexicanDish extends Dish {
        @Override
        public void serve() {
            System.out.println("Service du plat mexicain");
        }
    }
}
