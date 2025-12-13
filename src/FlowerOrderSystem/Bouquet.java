package src.FlowerOrderSystem;

import java.util.ArrayList;

public abstract class Bouquet implements InBloom {
    private final String type;
    private int size;
    private double bouqetPrice = 0;
    private String wrap;

    public Bouquet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setWrap(String wrap) {
        this.wrap = wrap;
    }

    public int  getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public double getBouqetPrice() {
        return bouqetPrice;
    }
    public void setBouqetPrice(double bouqetPrice) {
        if (size == 1){
            this.bouqetPrice += 30;
        } else if (size == 2){
            this.bouqetPrice += 50;
        } else{
            this.bouqetPrice += 100;
        }
        this.bouqetPrice += bouqetPrice;
    }
    public String getWrap() {
        return wrap;
    }
    public String getName(){
        return "bouquet";
    }

    public static class SmallBouquet extends Bouquet {
        public SmallBouquet() {
            super("SMALL");
            setSize(1);
        }
    }

    public static class MediumBouquet extends Bouquet {
        public MediumBouquet() {
            super("MEDIUM");
            setSize(2);
        }
    }

    public static class LargeBouquet extends Bouquet {
        public LargeBouquet() {
            super("LARGE");
            setSize(3);
        }
    }
    public static class BouquetFactory {
        public static Bouquet getBouquet(String bouquetType) {
            if (bouquetType == null) return null;

            switch (bouquetType.toUpperCase()) {
                case "SMALL":
                    System.out.println("small bouquet");
                    return new SmallBouquet();
                case "MEDIUM":
                    System.out.println("medium bouquet");
                    return new MediumBouquet();
                case "LARGE":
                    System.out.println("large bouquet");
                    return new LargeBouquet();
                default:
                    return null;
            }
        }
    }
}


