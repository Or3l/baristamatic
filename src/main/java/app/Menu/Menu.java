package app.Menu;

import app.Drink.Item;
import exception.OutOfStockException;

import java.util.Map;

public interface Menu {

    void populateMenu();

    Map<Integer, Item> getDrinks();

    void displayMenu();

    boolean canBeMade(Item item);

    void brewAndDispense(Item item) throws OutOfStockException;

    int size();



}
