package src.FlowerOrderSystem.Controllers;
import src.FlowerOrderSystem.Guest;
import src.FlowerOrderSystem.InvalidInputException;
import src.FlowerOrderSystem.User;

public class UserSetup {
    private  boolean guest;


    public User userFactory(String user) throws InvalidInputException {
        if (user.equals("Guest")) {
            return  new Guest();
        } else{
            return new User();
        }
    }

}
