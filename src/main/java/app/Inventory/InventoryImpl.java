package app.Inventory;

import app.Ingredient.Ingredient;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class InventoryImpl implements Inventory{

    private static final int initialQuantity = 10;
    private TreeMap<Ingredient, Integer> ingredients;
    private static volatile InventoryImpl instance;

    public static Inventory getInstance(){
        if(instance == null){
            synchronized (InventoryImpl.class){
                if(instance == null){
                    instance = new InventoryImpl();
                }
            }
        }
        return instance;
    }

    private InventoryImpl() {
        this.ingredients = new TreeMap<>(Comparator.comparing(Ingredient::getName));
        restockIngredients();
    }

    public void restockIngredients(){
        restockIngredients(initialQuantity);
    }

    public void restockIngredients(int quantity){
        ingredients.put(Ingredient.COFFEE, quantity);
        ingredients.put(Ingredient.CREAM, quantity);
        ingredients.put(Ingredient.SUGAR, quantity);
        ingredients.put(Ingredient.COCOA, quantity);
        ingredients.put(Ingredient.ESPRESSO, quantity);
        ingredients.put(Ingredient.DECAF_COFFEE, quantity);
        ingredients.put(Ingredient.FOAMED_MILK, quantity);
        ingredients.put(Ingredient.WHIPPED_CREAM, quantity);
        ingredients.put(Ingredient.STEAMED_MILK, quantity);
    }

    public TreeMap<Ingredient, Integer> getIngredients() {
        return ingredients;
    }


    public void remove(Ingredient ingredient, int quantity) {
        int new_quantity = ingredients.get(ingredient)-quantity;
        if(isInStock(ingredient, quantity)) ingredients.put(ingredient, new_quantity);

    }

    public boolean isInStock(Ingredient ingredient, int desireQuantity) {
        return ingredients.get(ingredient) >= desireQuantity;
    }

    public void displayInventory(){
        System.out.println("Inventory: ");
        for(Map.Entry<Ingredient, Integer> entry: ingredients.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
