package src.FlowerOrderSystem.Controllers;
import src.FlowerOrderSystem.Guest;
import src.FlowerOrderSystem.InvalidInputException;
import src.FlowerOrderSystem.User;

public class UserSetup {
    private final boolean guest;
    private User user;

    public UserSetup(Boolean guest) {
        this.guest = guest;
    }

    public User userType() throws InvalidInputException {
     if (this.guest){
         return new Guest(null,null, null);
     }
     return new User(null,null,null);
    }

}
