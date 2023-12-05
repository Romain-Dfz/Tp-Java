package org.example;
public class ItalianCuisineFactory extends CuisineFactory {
    @Override
    public FoodTypes.Ingredient createIngredient() {
        return new FoodTypes.ItalianIngredient();
    }

    @Override
    public FoodTypes.CookingUtensil createUtensil() {
        return new FoodTypes.ItalianUtensil();
    }

    @Override
    public FoodTypes.Dish createDish() {
        return new FoodTypes.ItalianDish();
    }
}
