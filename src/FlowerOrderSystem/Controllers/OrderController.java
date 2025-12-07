package src.FlowerOrderSystem.Controllers;

import src.FlowerOrderSystem.InvalidInputException;
import src.FlowerOrderSystem.Order;
import src.FlowerOrderSystem.Rose;
import src.FlowerOrderSystem.User;

public class OrderController {
    private MainController mainController;
    private User user;
    private Order order;
    public OrderController(MainController mainController){
        this.mainController = mainController;
        user = mainController.getUser();
        order = new Order();
    }

    public Order getOrder(){
        return order;
    }
    public void userActions(String action) throws InvalidInputException {
        mainController.changeDisplay(action);
    }

    public void removeFlower(String name){
        order.removeFlower(name);
    }
    public void addFlower(String name){
        order.addFlower(name);
    }

    public double getTotalPrice(){
        return order.getOrderPrice();
    }

    public int getStemStock(String name){
        return order.StemStock(name);
    }

    public void reduceStock(){
         order.reduceStemStock();
    }

    public boolean validIncrease(int ctr, String name){
        return order.stockIncrease(ctr, name);
    }

    public double setPrice (String name){
        return order.getPrice(name);
    }


}
