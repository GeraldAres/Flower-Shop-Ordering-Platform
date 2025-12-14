package src.FlowerOrderSystem;
import java.util.ArrayList;
import java.util.Iterator;


public class Order {
    private ArrayList<InBloom> Flowers;
    private double orderPrice = 0;
    private Inventory inventory = new Inventory();
    public Order(){
        Flowers = new ArrayList<>();
    }




    public void addFlower (String name, boolean isBouquet) {
        Factory factory;
        if (!isBouquet) {
            factory = new StemFactory();
            InBloom flower = factory.addInBloom(name);
            Flowers.add(flower);
            addPrice(flower);
            factory = null;
        }

        if (isBouquet) {
            String bouquetSize = name.split("-")[1];
            String bouquetName = name.split("-")[0];
            factory = new BouquetFactory();
            InBloom bouquet = factory.addInBloom(name);

            Factory stemFactory = new StemFactory();

            if (bouquetSize.equalsIgnoreCase("s")) {
                switch (bouquetName.toLowerCase()) {
                    case "rose":
                        Bouquet rose = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                        rose.setSize(1);
                        Flowers.add(rose);

                        double roseCount = 0;
                        for(int x = 1; x <= 3; x++){
                            InBloom stem = stemFactory.addInBloom("Rose");
                            roseCount += stem.getPrice();
                            Flowers.add(stem);
                        }

                        rose.setBouqetPrice(roseCount);
                        addPrice(rose);


                        break;

                    case "lily":
                        Bouquet lily = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                        lily.setSize(1);
                        Flowers.add(lily);

                        double lilyCount = 0;
                        for(int x = 1; x <= 3; x++){
                            InBloom stem = stemFactory.addInBloom("Lily");
                            lilyCount += stem.getPrice();
                            Flowers.add(stem);
                        }

                        lily.setBouqetPrice(lilyCount);
                        addPrice(lily);

                        break;
                    case "sunflower":
                        Bouquet sunflower = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                        sunflower.setSize(1);
                        Flowers.add(sunflower);

                        double sunflowerCount = 0;
                        for(int x = 1; x <= 3; x++){
                            InBloom stem = stemFactory.addInBloom("Sunflower");
                            sunflowerCount += stem.getPrice();
                            Flowers.add(stem);
                        }

                        sunflower.setBouqetPrice(sunflowerCount);
                        addPrice(sunflower);


                        break;

                    case "carnation":
                        Bouquet carnation = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                        carnation.setSize(1);
                        Flowers.add(carnation);

                        double carnationCount = 0;
                        for(int x = 1; x <= 3; x++){
                            InBloom stem = stemFactory.addInBloom("Carnation");
                            carnationCount += stem.getPrice();
                            Flowers.add(stem);
                        }

                        carnation.setBouqetPrice(carnationCount);
                        addPrice(carnation);


                        break;
                    case "tulip":
                        Bouquet tulip = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                        tulip.setSize(1);
                        Flowers.add(tulip);


                        double tulipCount = 0;
                        for(int x = 1; x <= 3; x++){
                            InBloom stem = stemFactory.addInBloom("Tulip");
                            tulipCount += stem.getPrice();
                            Flowers.add(stem);
                        }

                        tulip.setBouqetPrice(tulipCount);
                        addPrice(tulip);

                        break;
                    case "daisy":
                        Bouquet daisy = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                        daisy.setSize(1);
                        Flowers.add(daisy);


                        double daisyCount = 0;
                        for(int x = 1; x <= 3; x++){
                            InBloom stem = stemFactory.addInBloom("Daisy");
                            daisyCount += stem.getPrice();
                            Flowers.add(stem);
                        }


                        daisy.setBouqetPrice(daisyCount);
                        addPrice(daisy);
                        break;
                }
            }
                if (bouquetSize.equalsIgnoreCase("m")) {
                    switch (bouquetName.toLowerCase()) {
                        case "rose":
                            Bouquet rose = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                            rose.setSize(2);
                            Flowers.add(rose);

                            double roseCount = 0;
                            for(int x = 1; x <= 6; x++){
                                InBloom stem = stemFactory.addInBloom("Rose");
                                roseCount += stem.getPrice();
                                Flowers.add(stem);
                            }

                            rose.setBouqetPrice(roseCount);
                            addPrice(rose);


                            break;

                        case "lily":
                            Bouquet lily = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                            lily.setSize(2);
                            Flowers.add(lily);

                            double lilyCount = 0;
                            for(int x = 1; x <= 6; x++){
                                InBloom stem = stemFactory.addInBloom("Lily");
                                lilyCount += stem.getPrice();
                                Flowers.add(stem);
                            }

                            lily.setBouqetPrice(lilyCount);
                            addPrice(lily);

                            break;
                        case "sunflower":
                            Bouquet sunflower = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                            sunflower.setSize(2);
                            Flowers.add(sunflower);

                            double sunflowerCount = 0;
                            for(int x = 1; x <= 6; x++){
                                InBloom stem = stemFactory.addInBloom("Sunflower");
                                sunflowerCount += stem.getPrice();
                                Flowers.add(stem);
                            }

                            sunflower.setBouqetPrice(sunflowerCount);
                            addPrice(sunflower);


                            break;

                        case "carnation":
                            Bouquet carnation = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                            carnation.setSize(2);
                            Flowers.add(carnation);

                            double carnationCount = 0;
                            for(int x = 1; x <= 6; x++){
                                InBloom stem = stemFactory.addInBloom("Carnation");
                                carnationCount += stem.getPrice();
                                Flowers.add(stem);
                            }

                            carnation.setBouqetPrice(carnationCount);
                            addPrice(carnation);


                            break;
                        case "tulip":
                            Bouquet tulip = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                            tulip.setSize(2);
                            Flowers.add(tulip);


                            double tulipCount = 0;
                            for(int x = 1; x <= 6; x++){
                                InBloom stem = stemFactory.addInBloom("Tulip");
                                tulipCount += stem.getPrice();
                                Flowers.add(stem);
                            }

                            tulip.setBouqetPrice(tulipCount);
                            addPrice(tulip);

                            break;
                        case "daisy":
                            Bouquet daisy = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                            daisy.setSize(2);
                            Flowers.add(daisy);


                            double daisyCount = 0;
                            for(int x = 1; x <= 6; x++){
                                InBloom stem = stemFactory.addInBloom("Daisy");
                                daisyCount += stem.getPrice();
                                Flowers.add(stem);
                            }


                            daisy.setBouqetPrice(daisyCount);
                            addPrice(daisy);
                            break;
                    }
                }
                    if (bouquetSize.equalsIgnoreCase("l")) {
                        switch (bouquetName.toLowerCase()) {
                            case "rose":
                                Bouquet rose = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                                rose.setSize(3);
                                Flowers.add(rose);

                                double roseCount = 0;
                                for(int x = 1; x <= 12; x++){
                                    InBloom stem = stemFactory.addInBloom("Rose");
                                    roseCount += stem.getPrice();
                                    Flowers.add(stem);
                                }

                                rose.setBouqetPrice(roseCount);
                                addPrice(rose);


                                break;

                            case "lily":
                                Bouquet lily = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                                lily.setSize(3);
                                Flowers.add(lily);

                                double lilyCount = 0;
                                for(int x = 1; x <= 12; x++){
                                    InBloom stem = stemFactory.addInBloom("Lily");
                                    lilyCount += stem.getPrice();
                                    Flowers.add(stem);
                                }

                                lily.setBouqetPrice(lilyCount);
                                addPrice(lily);

                                break;
                            case "sunflower":
                                Bouquet sunflower = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                                sunflower.setSize(3);
                                Flowers.add(sunflower);

                                double sunflowerCount = 0;
                                for(int x = 1; x <= 12; x++){
                                    InBloom stem = stemFactory.addInBloom("Sunflower");
                                    sunflowerCount += stem.getPrice();
                                    Flowers.add(stem);
                                }

                                sunflower.setBouqetPrice(sunflowerCount);
                                addPrice(sunflower);


                                break;

                            case "carnation":
                                Bouquet carnation = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                                carnation.setSize(3);
                                Flowers.add(carnation);

                                double carnationCount = 0;
                                for(int x = 1; x <= 12; x++){
                                    InBloom stem = stemFactory.addInBloom("Carnation");
                                    carnationCount += stem.getPrice();
                                    Flowers.add(stem);
                                }

                                carnation.setBouqetPrice(carnationCount);
                                addPrice(carnation);


                                break;
                            case "tulip":
                                Bouquet tulip = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                                tulip.setSize(3);
                                Flowers.add(tulip);


                                double tulipCount = 0;
                                for(int x = 1; x <= 12; x++){
                                    InBloom stem = stemFactory.addInBloom("Tulip");
                                    tulipCount += stem.getPrice();
                                    Flowers.add(stem);
                                }

                                tulip.setBouqetPrice(tulipCount);
                                addPrice(tulip);

                                break;
                            case "daisy":
                                Bouquet daisy = (Bouquet) factory.addInBloom(bouquetName.toLowerCase());
                                daisy.setSize(3);
                                Flowers.add(daisy);


                                double daisyCount = 0;
                                for(int x = 1; x <= 12; x++){
                                    InBloom stem = stemFactory.addInBloom("Daisy");
                                    daisyCount += stem.getPrice();
                                    Flowers.add(stem);
                                }


                                daisy.setBouqetPrice(daisyCount);
                                addPrice(daisy);
                                break;
                        }
                    }// add flowers pero amount is dependent sa size sa bouquet (find logic unsaon pagkuha ato)
        }
    }

    public void removeBouquet(String name){

    }






    public void removeFlower(String name) {
        Bouquet targetBouquet = null;

        //pangita sa bouquet
        for (InBloom flower : Flowers) {

            if (flower instanceof Bouquet && flower.getName().equalsIgnoreCase(name.toLowerCase() + " bouquet")) {
                targetBouquet = (Bouquet) flower;
                break;
            }
        }

        //delete sa mga stem
        if (targetBouquet != null) {

            int stemsToRemove = 0;

            int size = targetBouquet.getSize();

            if (size == 1) {
                stemsToRemove = 3;
            } else if (size == 2) {
                stemsToRemove = 6;
            } else if (size == 3) {
                stemsToRemove = 12;
            }

            Flowers.remove(targetBouquet);
            removePrice(targetBouquet);

            Iterator<InBloom> it = Flowers.iterator();

            while (it.hasNext() && stemsToRemove > 0) {
                InBloom stem = it.next();

                if (!(stem instanceof Bouquet) && stem.getName().equalsIgnoreCase(name)) {
                    it.remove();
                    stemsToRemove--;
                }
            }
            return;
        } else {
            System.out.println("Bouquet not found.");
        }

        for (InBloom flower : Flowers){
            if (flower.getName().equalsIgnoreCase(name)){
                Flowers.remove(flower);
                removePrice(flower);
                return;
            }
        }
    }

    public int count(String name){
        int c = 0;

        for(InBloom flower : Flowers){
            if(flower.getName().equalsIgnoreCase(name)){
                c++;
            }
        }

        return c;
    }



    public ArrayList<InBloom> getFlowers() {
        return Flowers;
    }

    public void addPrice (InBloom stem){
      orderPrice += stem.getPrice();
    }

    public void removePrice(InBloom stem){
        orderPrice -= stem.getPrice();
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void print(){
        for(InBloom stem : Flowers){
            System.out.println(stem.getName());
        }
    }


    public int StemStock(String name) {
        return inventory.getStockCount(name);
    }

    public void reduceStemStock(){
        String[] flowerNames = {"Rose", "Daisy", "Tulip", "Carnation", "Sunflower", "Lily"};
        int[] counts = new int[flowerNames.length];

        for (InBloom flower : Flowers) {
            String name = flower.getName();
            for (int i = 0; i < flowerNames.length; i++) {
                if (name.equals(flowerNames[i])) {
                    counts[i]++;
                    break;
                }
            }
        }

        for (int i = 0; i < flowerNames.length; i++) {
            if (counts[i] > 0) {
                inventory.updateStock(flowerNames[i], counts[i]);
            }
        }


    }

    public boolean stockIncrease(int ctr, String name) {
       if (ctr < inventory.getStockCount(name)) {
           return true;
       }
        return false;
    }

    public double getPrice (String name){
        Stem temp ;
        if (name.equals("Rose")){
            temp = new Rose();
            return temp.getPrice();
        }
        if (name.equals("Daisy")){
            temp = new Daisy();
            return temp.getPrice();
        }
        if (name.equals("Tulip")){
            temp = new Tulip();
            return temp.getPrice();
        }
        if (name.equals("Carnation")){
            temp = new Carnation();
            return temp.getPrice();
        }
        if (name.equals("Sunflower")){
            temp = new Sunflower();
            return temp.getPrice();
        }
        if (name.equals("Lily")){
            temp = new Lily();
            return temp.getPrice();
        }
        return 0.00;
    }

    public String getColor (String name){
        Stem temp ;
        if (name.equals("Rose")){
            temp = new Rose();
            return temp.getColor();
        }
        if (name.equals("Daisy")){
            temp = new Daisy();
            return temp.getColor();
        }
        if (name.equals("Tulip")){
            temp = new Tulip();
            return temp.getColor();
        }
        if (name.equals("Carnation")){
            temp = new Carnation();
            return temp.getColor();
        }
        if (name.equals("Sunflower")){
            temp = new Sunflower();
            return temp.getColor();
        }
        if (name.equals("Lily")){
            temp = new Lily();
            return temp.getColor();
        }
        return "White";
    }
}
