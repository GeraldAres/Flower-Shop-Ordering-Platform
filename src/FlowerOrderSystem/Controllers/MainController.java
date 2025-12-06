package src.FlowerOrderSystem.Controllers;
import src.FlowerOrderSystem.InvalidInputException;
import src.FlowerOrderSystem.MainPanel;
import src.FlowerOrderSystem.User;

import javax.swing.*;

public class MainController {
    private MainPanel main;
    private User activeUser;

    public MainController(MainPanel main) {
        this.main = main;
    }
    public void setUser(){
        String action = main.getAction();
    }

    public void changeDisplay(String user) throws InvalidInputException {
        UserSetup setup = new UserSetup();
        if (user.equals("Guest")) {
            main.getCardLayout().show(main.getMainPanel(), "Guest");
            activeUser = setup.userFactory(user);
        }

        if (user.equals("Regular")) {
            main.getCardLayout().show(main.getMainPanel(), "LogInPanel");
            activeUser = setup.userFactory(user);
        }
    }

}
