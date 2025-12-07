package src.FlowerOrderSystem.Controllers;

import src.FlowerOrderSystem.Order;
import src.FlowerOrderSystem.User;

public class OrderController {
    private MainController mainController;
    private User user;
    private Order order;
    public OrderController(MainController mainController){
        this.mainController = mainController;
        user = mainController.getUser();
    }



}
