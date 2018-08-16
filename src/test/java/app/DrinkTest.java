package app;

import app.Drink.Drink;
import app.Drink.DrinkRecipeBuilder;
import app.Drink.Item;
import app.Ingredient.Ingredient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DrinkTest {

    private Item coffee;


    @Before
    public void setUp(){
        coffee = DrinkRecipeBuilder.buildCoffee();
    }

    @Test
    public void test_createDrink(){
        Drink drink  = new Drink("Coffee");
        assertNotNull(drink);
        assertNotNull(drink.getDrinkIngredients());
        assertEquals(0, drink.getDrinkIngredients().size());
        assertEquals("Coffee", drink.getName());
    }

    @Test
    public void test_createCoffeDrinkWithIngredients(){
        assertEquals(3, coffee.getDrinkIngredients().get(Ingredient.COFFEE).intValue());
        assertEquals(1, coffee.getDrinkIngredients().get(Ingredient.SUGAR).intValue());
        assertEquals(1, coffee.getDrinkIngredients().get(Ingredient.CREAM).intValue());
        assertEquals(2.75, coffee.getPrice(), 0);
    }


}