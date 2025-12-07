package src.FlowerOrderSystem;

public class PreMade extends Bouquet {
    private Stem stemFLower;
    int size;

    public PreMade(Stem stem, int size) {
        super("PreMade");
        stemFLower = stem;
        this.size = size;

        Order order = new Order();

        switch(size){
            //small
            case 1:
                if(stem.getName().equalsIgnoreCase("rose")){
                    for(int x = 1; x <= 3; x++){

                    }
                    System.out.println("small rose");
                }

                if(stem.getName().equalsIgnoreCase("lily")){
                    for(int x = 1; x <= 3; x++){

                    }
                    System.out.println("small lily");
                }

                if(stem.getName().equalsIgnoreCase("tulip")){
                    for(int x = 1; x <= 3; x++){

                    }
                    System.out.println("small tulip");
                }

                if(stem.getName().equalsIgnoreCase("sunflower")){
                    for(int x = 1; x <= 3; x++){

                    }
                    System.out.println("small sunflower");
                }
                break;

            case 2:
                if(stem.getName().equalsIgnoreCase("rose")){
                    for(int x = 1; x <= 6; x++){

                    }
                    System.out.println("medium rose");
                }

                if(stem.getName().equalsIgnoreCase("lily")){
                    for(int x = 1; x <= 6; x++){

                    }
                    System.out.println("medium lily");
                }

                if(stem.getName().equalsIgnoreCase("tulip")){
                    for(int x = 1; x <= 6; x++){

                    }
                    System.out.println("medium tulip");
                }

                if(stem.getName().equalsIgnoreCase("sunflower")){
                    for(int x = 1; x <= 6; x++){

                    }
                    System.out.println("medium sunflower");
                }
                break;

            case 3:
                if(stem.getName().equalsIgnoreCase("rose")){
                    for(int x = 1; x <= 12; x++){

                    }
                    System.out.println("large rose");
                }

                if(stem.getName().equalsIgnoreCase("lily")){
                    for(int x = 1; x <= 12; x++){

                    }
                    System.out.println("large lily");
                }

                if(stem.getName().equalsIgnoreCase("tulip")){
                    for(int x = 1; x <= 12; x++){

                    }
                    System.out.println("large tulip");
                }

                if(stem.getName().equalsIgnoreCase("sunflower")){
                    for(int x = 1; x <= 12; x++){

                    }
                    System.out.println("largez sunflower");
                }
                break;
        }
    }

    public Stem getFlower() {
        return stemFLower;
    }
}
