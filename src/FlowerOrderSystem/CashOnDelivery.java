package src.FlowerOrderSystem;

public class CashOnDelivery implements Payment {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Cash on Delivery selected.");
        System.out.println("Amount to be paid upon delivery: ₱" + amount);
        return true;
    }
}
