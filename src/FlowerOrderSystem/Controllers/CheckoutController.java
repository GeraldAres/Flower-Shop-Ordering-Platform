package src.FlowerOrderSystem.Controllers;

import src.FlowerOrderSystem.*;

import java.util.ArrayList;

public class CheckoutController implements Controller{
    private boolean controllingStatus;
    private CheckOut checkout;
    private MainController mainController;
    
    CheckoutController(User user, Order order, MainController mainController){
       checkout = new CheckOut(user, order);
       controllingStatus = true;
       this.mainController = mainController;
    }
    
    public boolean isControlling(){
        return controllingStatus;
    }
    public String getName() {
        return checkout.getUser().getFullName();
    }

    public String getEmail() {
        return checkout.getUser().getEmail();
    }

    public String getNumber(){
        return checkout.getUser().getContactNumber();
    }
    
    public void setAddress(String address){
        checkout.setAddressOfDelivery(address);
    }
    
    public void setPayment(String payment) throws InvalidInputException.PaymentFailedException {
        checkout.setModeOfPayment(payment);
    }
    
    public void setModeofDelivery(String mode){
        checkout.setModeOfDelivery(mode);
    }
    
    public void setReceipientName(String name){
        checkout.setReceipient(name);
    }

    public void validate(String modeOfDelivery, String modeOfPayment, String dateOfDelivery, String deliveryAdd, String receipientName) {
         checkout.orderValidator(modeOfDelivery,modeOfPayment,dateOfDelivery,deliveryAdd,receipientName);
    }


    public void processCheckout(String modeOfDelivery, String modeOfPayment, String dateOfDelivery, String deliveryAdd, String receipientName, ArrayList<String> addOns, double totalPrice, String instructions) throws InvalidInputException.PaymentFailedException, InvalidInputException {
        checkout.setAddOnsList(addOns);
        checkout.setModeOfDelivery(modeOfDelivery);
        checkout.setDateOfDelivery(dateOfDelivery);
        checkout.setAddressOfDelivery(deliveryAdd);
        checkout.setReceipient(receipientName);
        checkout.setTotalPrice(totalPrice);
        checkout.setSpecialInstructions(instructions);
        checkout.setModeOfPayment(modeOfPayment);
    }

    public ArrayList<String> getOrderSummaryLines() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<InBloom> flowers = checkout.getFlowers(); // still only in Controller

        ArrayList<InBloom> displayed = new ArrayList<>();
        for (InBloom flower : flowers) {
            if (alreadyDisplayed(displayed, flower)) continue;

            int count = 0;
            for (InBloom f : flowers) {
                if (f.getName().equals(flower.getName()) &&
                        f.getColor().equals(flower.getColor())) {
                    count++;
                }
            }


            String text = String.format(
                    "%-54s %5d   %7.2f",
                    flower.getName(),
                    count,
                    count * flower.getPrice()
            );

            lines.add(text);
            displayed.add(flower);
        }

        return lines;
    }

    private boolean alreadyDisplayed(ArrayList<InBloom> displayed, InBloom flower) {
        for (InBloom f : displayed) {
            if (f.getName().equals(flower.getName()) &&
                    f.getColor().equals(flower.getColor())) {
                return true;
            }
        }
        return false;
    }

    public double getOrderTotalPrice() {
        return checkout.getTotalPrice();
    }

    public CheckOut getCheckout() {
        return checkout;
    }


    public void userActions(String regular) throws InvalidInputException {
        mainController.changeDisplay(regular);
    }
}
