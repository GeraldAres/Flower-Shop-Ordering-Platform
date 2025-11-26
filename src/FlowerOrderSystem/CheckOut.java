package src.FlowerOrderSystem;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;

public class CheckOut {
    private NewForm newForm;
    private LocalDateTime orderID = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy hh:mm a");
    private String formatted = orderID.format(formatter);
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
        return formatted;
    }

    public String getContent() {
        return content;
    }

    public String getOrderID(){
        return formatted;
    }

    public void setContent() {
         this.content = "Order ID: " + getFormattedDate() +
                "\nMode of Delivery: " + getModeOfDelivery() +
                "\nAddress of Delivery: " + getAddressOfDelivery() +
                "\nMode of Payment: " + getModeOfPayment() +
                "\nDate of Delivery: " + getDateOfDelivery() +
                "\nNumber of Add-Ons: " + getNumsOfAddOns() +
                "\nAdd-Ons List: " + getAddOnsList() +
                "\nTotal Price: $" + getTotalPrice() +
                "\nSpecial Instructions: " + getSpecialInstructions() +
                "\nOrder Status: " + getOrderStatus();
    }

    public void saveToFile(String folderName, String filename) {
        try {
            File folder = new File(folderName);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
            File file = new File(folder, filename + ".txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write(content);
                    writer.newLine();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}