package app.Menu;

import app.Drink.DrinkRecipeBuilder;
import app.Drink.Item;
import app.Ingredient.Ingredient;
import app.Inventory.Inventory;
import exception.OutOfStockException;

import java.util.Map;
import java.util.TreeMap;

public class DrinkMenu implements Menu{

    Map<Integer, Item> drinks;
    private Inventory inventory;
    private static volatile DrinkMenu instance;

    public static Menu getInstance(Inventory inventory){
        if(instance == null){
            synchronized (DrinkMenu.class){
                if(instance == null){
                    instance  = new DrinkMenu(inventory);
                }
            }
        }
        return instance;
    }

    private DrinkMenu(Inventory inventory) {
        drinks = new TreeMap<>();
        this.inventory = inventory;
        populateMenu();
    }

    public void populateMenu(){
        Item coffee = DrinkRecipeBuilder.buildCoffee();
        Item caffeMocha = DrinkRecipeBuilder.builCaffeMocha();
        Item caffeAmericano = DrinkRecipeBuilder.buildCaffeAmericano();
        Item caffeLatte = DrinkRecipeBuilder.buildCaffeLatte();
        Item decaf = DrinkRecipeBuilder.buildDecaf();
        Item cappuccino = DrinkRecipeBuilder.buildCappuccino();

        drinks.put(1, caffeAmericano);
        drinks.put(2, caffeLatte);
        drinks.put(3, caffeMocha);
        drinks.put(4, cappuccino);
        drinks.put(5, coffee);
        drinks.put(6, decaf);
    }

    public Map<Integer, Item> getDrinks() {
        return drinks;
    }

    public void displayMenu(){
        System.out.println("Menu: ");
        drinks.forEach((k, v) -> {System.out.println(k+","+v+","+canBeMade(v));});
    }

    public boolean canBeMade(Item item){
        for (Ingredient ingredient: item.getDrinkIngredients().keySet()){
            if(!inventory.isInStock(ingredient, item.getDrinkIngredients().get(ingredient))) {
                return false;
            }
        }
        return true;
    }

    public void brewAndDispense(Item item) throws OutOfStockException {
        if(!canBeMade(item)) throw new OutOfStockException();

        for (Ingredient ingredient: item.getDrinkIngredients().keySet()){
            inventory.getIngredients().put(ingredient, inventory.getIngredients().get(ingredient)-item.getDrinkIngredients().get(ingredient));
        }
    }

    public int size(){
        return drinks.size();
    }

}
