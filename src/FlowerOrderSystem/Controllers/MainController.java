package src.FlowerOrderSystem.Controllers;
import src.FlowerOrderSystem.*;
import java.io.IOException;

public class MainController {
    private final MainPanel main;
    private  UserController setup;
    private  OrderController orderController;
    private SignUpPanel signUpPanel;
    private User activeUser;
    private Order order;

    public MainController(MainPanel main) {
        this.main = main;
        setup = new UserController(this);
        orderController = new OrderController(this);
    }

    public void changeDisplay(String action) throws InvalidInputException {
        if (action.equals("Guest")) {
            main.getCardLayout().show(main.getMainPanel(), "Guest");
            main.getGuestOrderPanel().setUserController(setup);
            activeUser = setup.userFactory(action);
        }

        if (action.equals("Regular")) {
            main.getLogInPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "LogInPanel");

        }
        if (action.equals("Logout")) {
            main.getLogInPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "LogInPanel");
            activeUser = null;

        }

        if (action.equals("SignUp")){
            main.getSignUpPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "SignUpPanel");
        }

        if (action.equals("Dashboard")) {
            main.getCardLayout().show(main.getMainPanel(), "Dashboard");
            main.getDashboardPanel().setController(this);
        };

        if (action.equals("LoggedIn")){
            activeUser = setup.getUser();
            main.getCardLayout().show(main.getMainPanel(), "Dashboard");
            main.getDashboardPanel().setController(this);

        }

        if (action.equals("NewOrder")){

            main.getCardLayout().show(main.getMainPanel(), "NewOrder");
        }

        if (action.equals("prev")){
            main.getCardLayout().show(main.getMainPanel(), "FirstPage");
        }
        if(action.equals("MyOrders")){
            main.getCardLayout().show(main.getMainPanel(), "MyOrders");
        }
        if (action.equals("Settings")){
            main.getCardLayout().show(main.getMainPanel(), "Settings");
        }
        if(action.equals("Flowers")){
            main.getCardLayout().show(main.getMainPanel(), "Flowers");
        }

    }

    public String getName(){
        if (activeUser != null) {
            String fullName = activeUser.getFullName().trim();
            return fullName.split(" ")[0];
        }
       return "Amigo";
    }

    public User getUser(){
        return activeUser;
    }

    public Order getOrder(){
        return order;
    }



}
