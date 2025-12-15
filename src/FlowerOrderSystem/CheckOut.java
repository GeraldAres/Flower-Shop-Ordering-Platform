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
            "Ongoing", "Ready for Delivery/Pick Up", "Cancelled", "Complete"
    );
    private ArrayList<String> orderItems = new ArrayList<>();

    public CheckOut(User user, Order order) {
        this.order = order;
        this.user = user;
        this.formattedDate = timestamp.format(displayFormatter);
        this.orderID = timestamp.format(idFormatter);
        this.orderStatus = "Pending";
        this.totalPrice = order.getOrderPrice();
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

    public void setModeOfPayment(String modeOfPayment) throws InvalidInputException.PaymentFailedException {
        this.modeOfPayment = modeOfPayment;
        Payment payment;
        switch (modeOfPayment) {
            case "Cash on Delivery":
                payment = new CashOnDelivery();
                if(payment.processPayment(totalPrice)){
                    saveOrder();
                } else{
                    throw new InvalidInputException.PaymentFailedException();
                }
                break;
            case "Gcash":
                payment = new GCash();
                if(payment.processPayment(totalPrice)){
                    saveOrder();
                } else{
                    throw new InvalidInputException.PaymentFailedException();
                }
                break;
            case "Bank Transfer":
                payment = new BankTransfer();
                if(payment.processPayment(totalPrice)){
                    saveOrder();
                } else{
                    throw new InvalidInputException.PaymentFailedException();
                }
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

    public String getOrderID() {
        return orderID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<String> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<String> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItem(String flowerName, String color, int qty, double price) {
        String line = String.format("%s(%s), %d pieces, P%.2f", flowerName, color, qty, price);
        this.orderItems.add(line);
    }

    public void updateContent() {
        String userName = (user != null) ? user.getFullName() : "default";
        String userEmail = (user != null) ? user.getEmail() : "default";
        String userContactNum = (user != null) ? user.getContactNumber() : "default";

        StringBuilder summaryBuilder = new StringBuilder();
        summaryBuilder.append("\nOrder Summary:");
            if (orderItems != null && !orderItems.isEmpty()) {
                for (String item : orderItems) {
                    summaryBuilder.append("\n\t").append(item);
                }
            } else {
                summaryBuilder.append(" None");
            }

        this.content = "Order ID: " + getOrderID() +
                "\nOrder Date: " + getFormattedDate() +
                "\nFull Name: " + userName +
                "\nEmail: " + userEmail +
                "\nContact Number: " + userContactNum +
                summaryBuilder.toString() +
                "\nMode of Delivery: " + getModeOfDelivery() +
                "\nAddress of Delivery: " + getAddressOfDelivery() +
                "\nMode of Payment: " + getModeOfPayment() +
                "\nDate of Delivery: " + getDateOfDelivery() +
                "\nReceipient: " + getReceipientName() +
                "\nNumber of Add-Ons: " + getNumsOfAddOns() +
                "\nAdd-Ons List: " + (addOnsList != null ? addOnsList.toString() : "None") +
                "\nTotal Price: P" + String.format("%.2f", getTotalPrice()) +
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

        user.addOrder(this);
    }

    public void setReceipient(String name) {
        this.receipientName = name;
    }

    public String getReceipientName() {
        return receipientName;
    }

    private boolean alreadyDisplayed(ArrayList<InBloom> displayed, InBloom flower) {
        for (InBloom f : displayed) {
            if (f.getName().equals(flower.getName()) && f.getColor().equals(flower.getColor())) {
                return true;
            }
        }
        return false;
    }
    public CheckOut.FlowerCountResult getFlowerCounts() {
        ArrayList<InBloom> displayed = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        ArrayList<InBloom> flowers = order.getFlowers();
        for (InBloom flower : flowers) {
            if (alreadyDisplayed(displayed, flower)) continue;

            int count = 0;
            for (InBloom f : flowers) {
                if (f.getName().equals(flower.getName()) && f.getColor().equals(flower.getColor())) {
                    count++;
                }
            }

            displayed.add(flower);
            counts.add(count);
        }

        return new FlowerCountResult(displayed, counts);
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

    public ArrayList<InBloom> getFlowers() {
        return order.getFlowers();
    }

    public void setAddOnsList(ArrayList<String> addOns) {
        this.addOnsList = addOns;
        setNumsOfAddOns(addOnsList.size());
        for (String addOn : addOnsList) {
            switch(addOn){
                case"Teddy":
                    totalPrice+=800;
                    break;
                case "Labubu":
                    totalPrice+= 2400;
                    break;
                case "Tobleron":
                    totalPrice+= 500;
                    break;
                case "Ferrero":
                    totalPrice+= 300;
            }
        }

    }

    public static class FlowerCountResult {
        private final ArrayList<InBloom> flowers;
        private final ArrayList<Integer> counts;

        public FlowerCountResult(ArrayList<InBloom> flowers, ArrayList<Integer> counts) {
            this.flowers = flowers;
            this.counts = counts;
        }

        public ArrayList<InBloom> getFlowers() {
            return flowers;
        }

        public ArrayList<Integer> getCounts() {
            return counts;
        }
    }

    public String getOrderDateForCard() {
        DateTimeFormatter idFormatter =
                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS");
        DateTimeFormatter displayFormatter =
                DateTimeFormatter.ofPattern("MMMM d, yyyy");

        LocalDateTime dateTime =
                LocalDateTime.parse(orderID, idFormatter);

        return dateTime.format(displayFormatter);
    }

}



