package src.FlowerOrderSystem;

import java.util.ArrayList;

public abstract class Stem {
    private final String name;
    private final String color;
    private final double price;
    private ArrayList<Stem> inventory;

    public Stem(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
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
