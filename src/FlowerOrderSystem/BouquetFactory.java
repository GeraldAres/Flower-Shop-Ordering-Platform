package src.FlowerOrderSystem;

public class BouquetFactory implements Factory{
    public Bouquet addInBloom(String name){
        switch (name.toLowerCase()) {
            case "rose":

                return new Bouquet.RoseBouquet();
            case "lily":

                return new Bouquet.LilyBouquet();
            case "sunflower":

                return new Bouquet.SunflowerBouquet();
            case "carnation":

                return new Bouquet.CarnationBouquet();
            case "tulip":

                return new Bouquet.TulipBouquet();
            case "daisy":


                return new Bouquet.DaisyBouquet();

            default:
                return null;
        }
    }
}