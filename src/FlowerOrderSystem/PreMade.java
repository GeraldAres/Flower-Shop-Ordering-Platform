package src.FlowerOrderSystem;

public class PreMade extends Bouquet {
    private Stem stemFLower;

    public PreMade(Stem stem) {
        super("PreMade");
        stemFLower = stem;


        if(stem.getName().equalsIgnoreCase("rose")){

        }
    }

    public Stem getFlower() {
        return stemFLower;
    }
}
