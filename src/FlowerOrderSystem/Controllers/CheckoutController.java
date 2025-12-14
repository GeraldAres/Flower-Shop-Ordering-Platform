package src.FlowerOrderSystem.Controllers;

import src.FlowerOrderSystem.CheckOut;
import src.FlowerOrderSystem.Order;
import src.FlowerOrderSystem.User;

import java.util.ArrayList;

public class CheckoutController implements Controller{
    private boolean controllingStatus;
    private CheckOut checkout;
    
    CheckoutController(User user, Order order){
       checkout = new CheckOut(user, order);
       controllingStatus = true;
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
    
    public void setPayment(String payment){
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

    public void processCheckout(String modeOfDelivery, String modeOfPayment, String dateOfDelivery, String deliveryAdd, String receipientName, ArrayList<String> addOns, double totalPrice) {
        checkout.setModeOfDelivery(modeOfDelivery);
        checkout.setDateOfDelivery(dateOfDelivery);
        checkout.setAddressOfDelivery(deliveryAdd);
        checkout.setReceipient(receipientName);
        checkout.setAddOnsList(addOns);
        checkout.setTotalPrice(totalPrice);
        checkout.setModeOfPayment(modeOfPayment);
    }
}
