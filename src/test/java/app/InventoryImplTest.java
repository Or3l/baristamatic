package app;

import app.Ingredient.Ingredient;
import app.Inventory.Inventory;
import app.Inventory.InventoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryImplTest {

    private Inventory inventory;

    @Before
    public void setUp(){
        inventory = InventoryImpl.getInstance();
    }

    @Test
    public void test_createInventory(){
        assertNotNull(inventory);
    }

    @Test
    public void test_restockIngredients(){
        inventory.restockIngredients();
        inventory.getIngredients().forEach((k, v) -> assertEquals(10, inventory.getIngredients().get(k).intValue()));
    }

    @Test
    public void test_removeIngredient(){
        inventory.remove(Ingredient.COFFEE, 3);
        assertEquals(7, inventory.getIngredients().get(Ingredient.COFFEE).intValue());
    }

    @Test
    public void test_restockIngredients_afterRemove(){
        inventory.remove(Ingredient.COFFEE, 3);
        inventory.restockIngredients();
        inventory.getIngredients().forEach((k, v) -> assertEquals(10, inventory.getIngredients().get(k).intValue()));
    }

    @Test
    public void test_isInStock_No(){
        assertFalse(inventory.isInStock(Ingredient.COFFEE, 11));
    }

    @Test
    public void test_isInStock_Yes(){
        assertTrue(inventory.isInStock(Ingredient.COFFEE, 4));
    }

}