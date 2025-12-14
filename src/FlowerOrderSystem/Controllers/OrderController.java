package src.FlowerOrderSystem.Controllers;

import src.FlowerOrderSystem.*;

import java.util.ArrayList;


public class OrderController implements Controller {
    private MainController mainController;
    private Order order;
    private Bouquet bouquet;
    private boolean controlStatus;

    public OrderController(MainController mainController){
        this.mainController = mainController;
        order = new Order();
        controlStatus = true;
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
        order.addFlower(name, false);
    }
    public void addBouquet(String name){ order.addFlower(name, true);}

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
    @Override
    public boolean isControlling() {
        return controlStatus;
    }
    public ArrayList<InBloom> getFlowers(){
        return order.getFlowers();
    }

    public void processCheckout(ArrayList<String> orderAddOns, String dateOfDelivery, String deliveryAddress, String finalModeOfDelivery, String finalModeOfPayment) {

    }

    public String getName() {
        return mainController.getUser().getFullName();
    }

    public String getEmail() {
        return mainController.getUser().getEmail();
    }

    public String getNumber(){
        return mainController.getUser().getContactNumber();
    }
}
