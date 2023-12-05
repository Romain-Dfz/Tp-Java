package org.example;
public abstract class CuisineFactory {
    public abstract FoodTypes.Ingredient createIngredient();
    public abstract FoodTypes.CookingUtensil createUtensil();
    public abstract FoodTypes.Dish createDish();
}
