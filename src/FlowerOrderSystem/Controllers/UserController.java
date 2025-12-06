package src.FlowerOrderSystem.Controllers;
import src.FlowerOrderSystem.*;

import java.io.IOException;

public class UserController {
    private User user;
    private final MainController mainController;
    private LogInPanel logInPanel;
    private SignUp signUp;

    public UserController(MainController mainController){
        this.mainController = mainController;
    }

    public User userFactory(String user) throws InvalidInputException {
        if (user.equals("Guest")) {
            return  new Guest();
        } else{
            return new User();
        }
    }

    public void logInValidation(String username, String password) throws InvalidInputException, IOException {
         LogIn login = new LogIn();
          user = login.validateLogIn(username, password);
          if (user != null) {
              userActions("Dashboard");
          }
    }

    public boolean signUpValidation(String fullName, String emailAddress, String contactNumber, String username, String password, String confirmPassword) throws InvalidInputException, IOException, InvalidInputException.InvalidEmail, InvalidInputException.InvalidName, InvalidInputException.InvalidPhone, InvalidInputException.PasswordMismatch, InvalidInputException.WeakPassword {
        SignUp signup = new SignUp();
        User test = signup.validateSignUp(fullName,  emailAddress, contactNumber, username, password, confirmPassword);
        if (test != null) {
            return true;
        }
        return false;
    }

    public void userActions(String action) throws InvalidInputException {
        mainController.changeDisplay(action);
    }

}
