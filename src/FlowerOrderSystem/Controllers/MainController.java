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
    }

    public void changeDisplay(String action) throws InvalidInputException {
        if (action.equals("Guest")) {
            main.getCardLayout().show(main.getMainPanel(), "Guest");
            activeUser = setup.userFactory(action);
        }

        if (action.equals("Regular")) {
            main.getLogInPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "LogInPanel");

        }

        if (action.equals("SignUp")){
            main.getSignUpPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "SignUpPanel");
        }

        if (action.equals("Dashboard")) {
            main.getCardLayout().show(main.getMainPanel(), "Dashboard");
        };

    }







}
