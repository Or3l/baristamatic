package app.Drink;

import app.Ingredient.Ingredient;

import java.util.EnumMap;
import java.util.Map;

public class Drink implements Item {


    private String name;
    //contains the ingredients and the quantity needed
    private EnumMap<Ingredient, Integer> drinkIngredients;
    private double price;


    public Drink(String name) {
        this.name = name;
        this.drinkIngredients = new EnumMap(Ingredient.class);
        this.price = 0d;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<Ingredient, Integer> getDrinkIngredients() {
        return drinkIngredients;
    }

    @Override
    public void setDrinkIngredients(EnumMap<Ingredient, Integer> drinkIngredients) {
        this.drinkIngredients = drinkIngredients;
    }

    @Override
    public Drink addIngredient(Ingredient ingredient, Integer quantity){
        drinkIngredients.put(ingredient, quantity);
        this.price += ingredient.getPrice()*quantity;
        return this;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String strprice = String.format("%.2f", price);
        return name+",$"+strprice;
    }
}
