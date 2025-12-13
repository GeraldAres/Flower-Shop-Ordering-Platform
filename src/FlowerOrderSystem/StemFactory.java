package src.FlowerOrderSystem;

public class StemFactory implements  Factory {

    public Stem addInBloom(String name) {
        switch (name) {
            case "Rose":
                return new Rose();
            case "Sunflower":
                return new Sunflower();
            case "Carnation":
                return new Carnation();
            case "Tulip":
                return new Tulip();
            case "Lily":
                return new Lily();
            case "Daisy":
                return new Daisy();
        }
        return null;

    }




}
