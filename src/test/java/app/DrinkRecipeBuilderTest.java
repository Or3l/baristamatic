package app;

import app.Drink.DrinkRecipeBuilder;
import app.Drink.Item;
import app.Ingredient.Ingredient;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkRecipeBuilderTest {

    @Test
    public void test_coffeeCreation(){
        Item drink = DrinkRecipeBuilder.buildCoffee();
        assertEquals("Coffee", drink.getName());
        assertEquals(2.75, drink.getPrice(),0);
        assertEquals(3, drink.getDrinkIngredients().get(Ingredient.COFFEE).intValue());
        assertEquals(1, drink.getDrinkIngredients().get(Ingredient.SUGAR).intValue());
        assertEquals(1, drink.getDrinkIngredients().get(Ingredient.CREAM).intValue());
    }

}