package org.example;
public class MexicanCuisineFactory extends CuisineFactory {
    @Override
    public FoodTypes.Ingredient createIngredient() {
        return new FoodTypes.MexicanIngredient();
    }

    @Override
    public FoodTypes.CookingUtensil createUtensil() {
        return new FoodTypes.MexicanUtensil();
    }

    @Override
    public FoodTypes.Dish createDish() {
        return new FoodTypes.MexicanDish();
    }
}
