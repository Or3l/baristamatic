package app.Drink;

import app.Ingredient.Ingredient;

import java.util.EnumMap;
import java.util.Map;

public interface Item {

    String getName();

    void setName(String name);

    Map<Ingredient, Integer> getDrinkIngredients();

    void setDrinkIngredients(EnumMap<Ingredient, Integer> drinkIngredients);

    Drink addIngredient(Ingredient ingredient, Integer quantity);

    double getPrice();
}
