package app.Ingredient;

public enum Ingredient {

    COFFEE ("Coffee", 0.75),
    DECAF_COFFEE ("Decaf Coffee", 0.75),
    SUGAR ("Sugar", 0.25),
    CREAM ("Cream", 0.25),
    STEAMED_MILK ("Steamed Milk", 0.35),
    FOAMED_MILK("Foamed Milk", 0.35),
    ESPRESSO("Espresso", 1.10),
    COCOA("Cocoa", 0.90),
    WHIPPED_CREAM("Whipped Cream", 1.00);

    private String name;
    private double price;

    Ingredient(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
