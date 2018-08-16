package app;

import app.Drink.Drink;
import app.Drink.Item;
import app.Ingredient.Ingredient;
import app.Inventory.Inventory;
import app.Inventory.InventoryImpl;
import app.Menu.DrinkMenu;
import app.Menu.Menu;
import exception.OutOfStockException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkMenuTest {

    private Inventory inventory;
    private Menu menu;

    @Before
    public void setUp(){
        inventory = InventoryImpl.getInstance();
        inventory.restockIngredients();
        menu = DrinkMenu.getInstance(inventory);
    }

    @Test
    public void test_populateMenu(){
        menu.populateMenu();
        assertEquals(6, menu.getDrinks().size());
    }

    @Test
    public void test_menuSize(){
        assertEquals(6, menu.size());
    }

    @Test
    public void test_canBeMade_true(){
        Item item = menu.getDrinks().get(1);
        assertTrue(menu.canBeMade(item));
    }

    @Test
    public void test_canBeMade_false(){
        Item item = new Drink("test").addIngredient(Ingredient.ESPRESSO, 11);
        assertFalse(menu.canBeMade(item));
    }

    @Test
    public void test_brewAndDispense() throws OutOfStockException {
        Item item = menu.getDrinks().get(1);
        menu.brewAndDispense(item);
        assertEquals(7, inventory.getIngredients().get(Ingredient.ESPRESSO).intValue());
    }

    @Test
    public void test_brewAndDispense_notInStock() {
        Item item = menu.getDrinks().get(1);
        try {
            menu.brewAndDispense(item);
            menu.brewAndDispense(item);
            menu.brewAndDispense(item);
            menu.brewAndDispense(item);
            fail("No exception thrown");
        } catch (OutOfStockException e) {
            e.printStackTrace();
        }


    }



}