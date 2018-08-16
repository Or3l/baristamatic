package app.Inventory;

import app.Ingredient.Ingredient;

import java.util.TreeMap;

public interface Inventory {

    void restockIngredients();
    void restockIngredients(int quantity);
    TreeMap<Ingredient, Integer> getIngredients();
    void remove(Ingredient ingredient, int quantity);
    boolean isInStock(Ingredient ingredient, int desireQuantity);
    void displayInventory();
}
