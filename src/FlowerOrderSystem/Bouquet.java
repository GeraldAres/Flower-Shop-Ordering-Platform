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

    public static  class RoseBouquet extends Bouquet {
        public RoseBouquet() {
            super("Rose");
        }

        @Override
        public String getName() {
            return "rose bouquet";
        }

        @Override
        public String getColor() {
            return "";
        }

        @Override
        public double getPrice() {
            return getBouqetPrice();
        }
    }

    public static   class LilyBouquet extends Bouquet {
        public LilyBouquet() {
            super("Lily");
        }

        @Override
        public String getName() {
            return "lily bouquet";
        }

        @Override
        public String getColor() {
            return "";
        }

        @Override
        public double getPrice() {
            return getBouqetPrice();
        }
    }

    public static  class SunflowerBouquet extends Bouquet {
        public SunflowerBouquet() {
            super("Sunflower");
        }

        @Override
        public String getName() {
            return "sunflower bouquet";
        }

        @Override
        public String getColor() {
            return "";
        }

        @Override
        public double getPrice() {
            return getBouqetPrice();
        }
    }

    public static  class CarnationBouquet extends Bouquet {
        public CarnationBouquet() {
            super("Carnation");
        }

        @Override
        public String getName() {
            return "carnation bouquet";
        }

        @Override
        public String getColor() {
            return "";
        }

        @Override
        public double getPrice() {
            return getBouqetPrice();
        }
    }

    public static  class TulipBouquet extends Bouquet {
        public TulipBouquet() {
            super("Tulip");
        }

        @Override
        public String getName() {
            return "tulip bouquet";
        }

        @Override
        public String getColor() {
            return "";
        }

        @Override
        public double getPrice() {
            return getBouqetPrice();
        }
    }

    public static  class DaisyBouquet extends Bouquet {
        public DaisyBouquet() {
            super("Daisy");
        }

        @Override
        public String getName() {
            return "daisy bouquet";
        }

        @Override
        public String getColor() {
            return "";
        }

        @Override
        public double getPrice() {
            return getBouqetPrice();
        }
    }

}


