package src.FlowerOrderSystem.Controllers;
import src.FlowerOrderSystem.*;

import java.io.IOException;
import java.util.ArrayList;

public class UserController implements Controller {
    private User user;
    private final MainController mainController;
    private LogInPanel logInPanel;
    private SignUp signUp;
    private boolean controlStatus;

    public UserController(MainController mainController){
        this.mainController = mainController;
        controlStatus = true;
    }

    public User userFactory(String action) throws InvalidInputException {
        if (action.equals("Guest")) {
            user = new Guest();
        }
        return user;
    }

    public void logInValidation(String username, String password) throws InvalidInputException, IOException {
         LogIn login = new LogIn();
          user = login.validateLogIn(username, password);
          if (user != null) {
              user.loadOrdersFromViewOrder();
              userActions("LoggedIn");
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

    public User getUser(){
        return user;
    }

    public boolean validateName(String name) throws InvalidInputException.InvalidName {
       return User.validateName(name);
    }

    public boolean validatePhone(String phone) throws InvalidInputException.InvalidPhone {
        return User.validatePhone(phone);
    }

    public boolean validateEmail(String email) throws InvalidInputException.InvalidEmail {
        return User.validateEmail(email);
    }

    @Override
    public boolean isControlling() {
        return controlStatus;
    }


    public ArrayList<CheckOut> getCompletedOrders() {
        return user.getOrders();
    }


    public void openViewOrder(CheckOut order) {
        mainController.setSelectedOrder(order);
        try {
            mainController.changeDisplay("viewThis");
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
