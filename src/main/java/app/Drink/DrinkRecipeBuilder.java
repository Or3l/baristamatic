package app.Drink;

import app.Ingredient.Ingredient;

public class DrinkRecipeBuilder {

    public static final String coffee = "Coffee";
    public static final String decaf_coffee = "Decaf Coffee";
    public static final String caffe_latte = "Caffe Latte";
    public static final String caffe_americano = "Caffe Americano";
    public static final String caffe_mocha = "Caffe Mocha";
    public static final String cappuccino = "Cappuccino";

    public static Item buildCoffee(){
        return new Drink(coffee).addIngredient(Ingredient.COFFEE, 3)
                .addIngredient(Ingredient.SUGAR, 1)
                .addIngredient(Ingredient.CREAM,1);
    }

    public static Item buildDecaf(){
        return new Drink(decaf_coffee).addIngredient(Ingredient.DECAF_COFFEE, 3)
                .addIngredient(Ingredient.SUGAR,1)
                .addIngredient(Ingredient.CREAM, 1);
    }

    public static Item buildCaffeLatte(){
        return new Drink(caffe_latte).addIngredient(Ingredient.ESPRESSO,2)
                .addIngredient(Ingredient.STEAMED_MILK,1);
    }

    public static Item buildCaffeAmericano(){
        return new Drink(caffe_americano).addIngredient(Ingredient.ESPRESSO,3);
    }

    public static Item builCaffeMocha(){
        return new Drink(caffe_mocha).addIngredient(Ingredient.ESPRESSO,1)
                .addIngredient(Ingredient.COCOA, 1)
                .addIngredient(Ingredient.STEAMED_MILK,1)
                .addIngredient(Ingredient.WHIPPED_CREAM,1);
    }

    public static Item buildCappuccino(){
        return new Drink(cappuccino).addIngredient(Ingredient.ESPRESSO,2)
                .addIngredient(Ingredient.STEAMED_MILK,1)
                .addIngredient(Ingredient.FOAMED_MILK, 1);
    }
}
