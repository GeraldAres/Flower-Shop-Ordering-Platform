package src.FlowerOrderSystem.Controllers;

import src.FlowerOrderSystem.*;

public class OrderController {
    private MainController mainController;
    private Order order;
    private Bouquet bouquet;
    public OrderController(MainController mainController){
        this.mainController = mainController;
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

    public String setColor(String name){
        return order.getColor(name);
    }

    public Bouquet getBouquet(){
        return bouquet;
    }

    public void setBouquetWrapper(String color){
        bouquet.setWrap(color);
    }

    public void setBouquetSize(int size){
        bouquet.setSize(size);
    }

    public int getBouquetSize(){
        return bouquet.getSize();
    }



}
