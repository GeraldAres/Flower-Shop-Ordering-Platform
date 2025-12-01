package src.FlowerOrderSystem;

import java.util.ArrayList;

public abstract class Stem {
    private final String name;
    private final String color;
    private final double price;
    private ArrayList<Stem> inventory;

    public Stem(String name, String color, double price, ArrayList<Stem> Inventory) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public double getPrice() {
        return price;
    }

}
