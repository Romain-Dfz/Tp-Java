package org.example;
public class JapaneseCuisineFactory extends CuisineFactory {
    @Override
    public FoodTypes.Ingredient createIngredient() {
        return new FoodTypes.JapaneseIngredient();
    }

    @Override
    public FoodTypes.CookingUtensil createUtensil() {
        return new FoodTypes.JapaneseUtensil();
    }

    @Override
    public FoodTypes.Dish createDish() {
        return new FoodTypes.JapaneseDish();
    }
}
