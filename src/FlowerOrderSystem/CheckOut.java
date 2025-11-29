package src.FlowerOrderSystem;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;

public class CheckOut {
    private NewForm newForm;
    private LocalDateTime timestamp = LocalDateTime.now();
    private DateTimeFormatter idFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    private DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("MM-dd-yy hh:mm a");
    private String orderID;
    private String formattedDate;
    private String modeOfDelivery;
    private String addressOfDelivery;
    private String modeOfPayment;
    private String dateOfDelivery;
    private int numsOfAddOns;
    private ArrayList<String> addOnsList = new ArrayList<>();
    private double totalPrice;
    private String specialInstructions;
    private String orderStatus;
    private String content;

    public CheckOut(NewForm newForm) {
        this.newForm = newForm;
        this.formattedDate = timestamp.format(displayFormatter);
        this.orderID = timestamp.format(idFormatter);
        this.orderStatus = "Pending";
    }

    public CheckOut(String orderId, String customerName, String flower, double total, String date) {
        this.orderID = orderId;
        this.formattedDate = date;
        this.totalPrice = total;
    }

    public String getModeOfDelivery() {
        return modeOfDelivery;
    }

    public void setModeOfDelivery(String modeOfDelivery) {
        this.modeOfDelivery = modeOfDelivery;
    }

    public String getAddressOfDelivery() {
        return addressOfDelivery;
    }

    public void setAddressOfDelivery(String addressOfDelivery) {
        this.addressOfDelivery = addressOfDelivery;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public int getNumsOfAddOns() {
        return numsOfAddOns;
    }

    public void setNumsOfAddOns(int numsOfAddOns) {
        this.numsOfAddOns = numsOfAddOns;
    }

    public ArrayList<String> getAddOnsList() {
        return addOnsList;
    }

    public void setAddOnsList(ArrayList<String> addOnsList) {
        this.addOnsList = addOnsList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public String getContent() {
            updateContent();
        return content;
    }

    public String getOrderID(){
        return orderID;
    }

    public void updateContent() {
        this.content = "Order ID: " + getOrderID() +
                "\nOrder Date: " + getFormattedDate() +
                "\nMode of Delivery: " + getModeOfDelivery() +
                "\nAddress of Delivery: " + getAddressOfDelivery() +
                "\nMode of Payment: " + getModeOfPayment() +
                "\nDate of Delivery: " + getDateOfDelivery() +
                "\nNumber of Add-Ons: " + getNumsOfAddOns() +
                "\nAdd-Ons List: " + (addOnsList != null ? addOnsList.toString() : "None") +
                "\nTotal Price: $" + String.format("%.2f", getTotalPrice()) +
                "\nSpecial Instructions: " + (specialInstructions != null ? specialInstructions : "None") +
                "\nOrder Status: " + getOrderStatus();
    }

    public void saveOrderToUserFolder(String username) {
        updateContent();
        String mainFolderName = "Orders";
        File userFolder = new File(mainFolderName, username);
            if (!userFolder.exists()) {
                boolean created = userFolder.mkdirs();
                    if (!created) {
                        System.err.println("Error: Could not create directory " + userFolder.getPath());
                        return;
                    }
            }
        File file = new File(userFolder, getOrderID() + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
                System.out.println("Order saved successfully to: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error saving order: " + e.getMessage());
                e.printStackTrace();
            }
    }
}