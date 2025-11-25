package src.FlowerOrderSystem;

public class PreMade extends Bouquet {
    private String name;
    public PreMade() {
        super("PreMade");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
