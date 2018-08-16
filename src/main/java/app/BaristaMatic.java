package app;

import app.Drink.Item;
import app.Inventory.Inventory;
import app.Inventory.InventoryImpl;
import app.Menu.DrinkMenu;
import app.Menu.Menu;
import exception.OutOfStockException;

import java.util.Scanner;

public class BaristaMatic {

    private static final String INVALID_SELECTION = "Invalid selection: ";
    private static final String OUT_OF_STOCK = "Out of stock: ";
    private static final String DISPENSING = "Dispensing: ";

    public static void main (String[] args){

        Inventory inventory = InventoryImpl.getInstance();
        Menu menu = DrinkMenu.getInstance(inventory);
        Integer menuSize = menu.size();
        int maxPossibleLength = menuSize.compareTo(0) == 0 ? 0 : menuSize.toString().length();

        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean commandEmpty = false;

        while(true){

            //if it was a blank command, do nothing
            if(!commandEmpty) {
                inventory.displayInventory();
                menu.displayMenu();
            }
            userInput = scanner.nextLine();
            userInput = userInput.trim();

            //if blank command, ignore
            if(userInput.isEmpty()) {
                commandEmpty = true;
                continue;
            } else {
                commandEmpty = false;
            }

            //if not a integer, then input must be 'q' or 'r'
            if(!isInteger(userInput.toCharArray())){
                if(!isAuthorizedCharacter(userInput)){
                    System.out.println(INVALID_SELECTION + userInput);
                    continue;
                }
            }

            //if it is an integer, need to check that the selection entered matches the number of items in the menu
            if (isInteger(userInput.toCharArray()) && userInput.length() > maxPossibleLength) {
                System.out.println(INVALID_SELECTION+userInput);
                continue;
            }

            Integer selection = null;
            if(isInteger(userInput.toCharArray())){
                selection = Integer.parseInt(userInput);
                if(!isAuthorizedSelection(selection, menuSize)){
                    System.out.println(INVALID_SELECTION + userInput);
                    continue;
                }
            }

            if(Character.toLowerCase(userInput.toCharArray()[0]) == 'q') break;

            if (Character.toLowerCase(userInput.toCharArray()[0]) == 'r') {
                inventory.restockIngredients();
                continue;
            }

            //if selection is >=1 && <=6
            Item drink = menu.getDrinks().get(selection);
            try {
                menu.brewAndDispense(drink);
                System.out.println(DISPENSING+drink.getName());
            } catch (OutOfStockException e) {
                System.out.println(OUT_OF_STOCK+drink.getName());
            }

        }
        scanner.close();
    }

    public static boolean isInteger(char[] userInput){
        for(char c: userInput){
            if((int)c<48 || (int)c>57){
                return false;
            }
        }
        return true;
    }


    public static boolean isAuthorizedCharacter(String userInput){
        if( userInput.length() > 1 ||
                (Character.toLowerCase(userInput.toCharArray()[0]) != 'q' && Character.toLowerCase(userInput.toCharArray()[0]) != 'r' )){
            return false;
        }
        return true;
    }

    public static boolean isAuthorizedSelection(Integer selection, Integer maxSelection){
        if(selection.compareTo(maxSelection) > 0 || selection.compareTo(1) < 0) {
            return false;
        }
        return true;

    }



}
