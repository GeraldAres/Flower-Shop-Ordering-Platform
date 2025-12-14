package src.FlowerOrderSystem;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;

public class CheckOut {
    private Order order;
    private User user;
    private LocalDateTime timestamp = LocalDateTime.now();
    private DateTimeFormatter idFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS");
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
    private String receipientName;
    private static final List<String> ORDER_STATUS = Arrays.asList(
            "Ongoing" , "Ready for Delivery/Pick Up" , "Cancelled", "Complete"
    );

    public CheckOut(User user, Order order) {
        this.order = order;
        this.user = user;
        this.formattedDate = timestamp.format(displayFormatter);
        this.orderID = timestamp.format(idFormatter);
        this.orderStatus = "Pending";
    }

    public CheckOut(String orderId, String customerName, String flower, double total, String date) {
        this.orderID = orderId;
        this.formattedDate = date;
        this.totalPrice = total;
        this.user = new User(customerName, "N/A", "N/A", "N/A", "N/A");
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
        Payment payment;
        switch(modeOfPayment){
            case "Cash on Delivery":
                payment = new CashOnDelivery();
                payment.processPayment(totalPrice);
                break;
            case "Gcash":
                payment = new GCash();
                payment.processPayment(totalPrice);
                break;
            case "Bank Transfer":
                payment = new BankTransfer();
                payment.processPayment(totalPrice);
                break;

        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void updateContent() {
        String userName = (user != null) ? user.getFullName() : "default";
        String userEmail = (user != null) ? user.getEmail() : "default";
        String userContactNum = (user != null) ? user.getContactNumber() : "default";

        this.content = "Order ID: " + getOrderID() +
                "\nOrder Date: " + getFormattedDate() +
                "\nFull Name: " + userName +
                "\nEmail: " + userEmail +
                "\nContact Number: " + userContactNum +
                "\nMode of Delivery: " + getModeOfDelivery() +
                "\nAddress of Delivery: " + getAddressOfDelivery() +
                "\nMode of Payment: " + getModeOfPayment() +
                "\nDate of Delivery: " + getDateOfDelivery() +
                "\nReceipient: " + getReceipientName() +
                "\nNumber of Add-Ons: " + getNumsOfAddOns() +
                "\nAdd-Ons List: " + (addOnsList != null ? addOnsList.toString() : "None") +
                "\nTotal Price: $" + String.format("%.2f", getTotalPrice()) +
                "\nSpecial Instructions: " + (specialInstructions != null ? specialInstructions : "None") +
                "\nOrder Status: " + getOrderStatus();
    }

    public boolean changeOrderStatus(String newStatus) {
        boolean isValid = false;
        String formattedStatus = "";

            for (String valid : ORDER_STATUS) {
                if (valid.equalsIgnoreCase(newStatus)) {
                    formattedStatus = valid;
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {
                System.err.println("Error: '" + newStatus + "' is not a valid status.");
                System.out.println("Allowed statuses: " + ORDER_STATUS);
                return false;
            }

        this.orderStatus = formattedStatus;
        updateContent();
        saveOrder();

        System.out.println("Order " + getOrderID() + " updated to: " + formattedStatus);
        return true;
    }

    public void saveOrder() {
        updateContent();
        String mainFolderName = "Orders";
        String folderName;
            if (user.getUsername().equals("default")) {
                folderName = "Guest";
            } else {
                folderName = user.getUsername();
            }
        File userFolder = new File(mainFolderName, folderName);
            if (!userFolder.exists()) {
                userFolder.mkdirs();
            }
        File file = new File(userFolder, getOrderID() + ".txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(content);
            } catch (IOException e) {
                System.err.println("Error saving order: " + e.getMessage());
                e.printStackTrace();
            }
    }

    public void setReceipient(String name) {
        this.receipientName = name;
    }

    public String getReceipientName() {
        return receipientName;
    }

    public void orderValidator(
            String modeOfDelivery,
            String modeOfPayment,
            String dateOfDelivery,
            String deliveryAdd,
            String recipientName
    ) {

        if (modeOfDelivery == null || modeOfDelivery.trim().isEmpty()
                || modeOfDelivery.equalsIgnoreCase("Select One")) {
            throw new IllegalArgumentException("Please select a valid mode of delivery.");
        }

        if (modeOfPayment == null || modeOfPayment.trim().isEmpty()
                || modeOfPayment.equalsIgnoreCase("Select One")) {
            throw new IllegalArgumentException("Please select a valid mode of payment.");
        }

        if (dateOfDelivery == null || dateOfDelivery.trim().isEmpty()) {
            throw new IllegalArgumentException("Date of delivery must not be empty.");
        }

        if (deliveryAdd == null || deliveryAdd.trim().isEmpty()) {
            throw new IllegalArgumentException("Delivery address must not be empty.");
        }

        if (recipientName == null || recipientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient name must not be empty.");
        }
    }


}