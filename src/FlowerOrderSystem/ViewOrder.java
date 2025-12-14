package src.FlowerOrderSystem;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ViewOrder {

    private ArrayList<CheckOut> ordersList = new ArrayList<>();

    public void loadFromFile(String username) {
        ordersList.clear();

        File folder = new File("Orders/" + username);
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("No orders found for user: " + username);
                return;
            }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files == null || files.length == 0) {
                System.out.println("No order files found.");
                return;
            }

                for (File file : files) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String orderId = "Unknown";
                        String orderDate = "Unknown";
                        String priceStr = "0";
                        String modeOfDelivery = "Unknown";
                        String addressOfDelivery = "Unknown";
                        String modeOfPayment = "Unknown";
                        String dateOfDelivery = "Unknown";
                        String specialInstructions = "None";
                        String orderStatus = "Pending";
                        String numsAddOnsStr = "0";
                        String addOnsRaw = "None";
                        String line;

                            while ((line = reader.readLine()) != null) {
                                if (line.contains(":")) {
                                    String[] parts = line.split(":", 2);
                                        if (parts.length == 2) {
                                            String key = parts[0].trim();
                                            String value = parts[1].trim();

                                                if (key.equals("Order ID")) {
                                                    orderId = value;
                                                } else if (key.equals("Order Date")) {
                                                    orderDate = value;
                                                } else if (key.equals("Total Price")) {
                                                    priceStr = value;
                                                } else if (key.equals("Mode of Delivery")) {
                                                    modeOfDelivery = value;
                                                } else if (key.equals("Address of Delivery")) {
                                                    addressOfDelivery = value;
                                                } else if (key.equals("Mode of Payment")) {
                                                    modeOfPayment = value;
                                                } else if (key.equals("Date of Delivery")) {
                                                    dateOfDelivery = value;
                                                } else if (key.equals("Special Instructions")) {
                                                    specialInstructions = value;
                                                } else if (key.equals("Order Status")) {
                                                    orderStatus = value;
                                                } else if (key.equals("Number of Add-Ons")) {
                                                    numsAddOnsStr = value;
                                                } else if (key.equals("Add-Ons List")) {
                                                    addOnsRaw = value;
                                                }
                                        }
                                }
                            }

                        double totalPrice = 0.0;
                            try {
                                totalPrice = Double.parseDouble(priceStr.replace("$", "").trim());
                            } catch (NumberFormatException e) {
                                totalPrice = 0.0;
                            }

                        int numsOfAddOns = 0;
                            try {
                                numsOfAddOns = Integer.parseInt(numsAddOnsStr);
                            } catch (NumberFormatException e) {
                                numsOfAddOns = 0;
                            }

                        ArrayList<String> addOns = new ArrayList<>();
                            if (addOnsRaw != null && !addOnsRaw.equals("None")) {
                                addOnsRaw = addOnsRaw.replace("[", "").replace("]", "");
                                    if (!addOnsRaw.isBlank()) {
                                        String[] items = addOnsRaw.split(",");
                                            for (String s : items) {
                                                addOns.add(s.trim());
                                            }
                                    }
                            }

                        CheckOut order = new CheckOut(orderId, null, null, totalPrice, orderDate);

                        order.setModeOfDelivery(modeOfDelivery);
                        order.setAddressOfDelivery(addressOfDelivery);
                        order.setModeOfPayment(modeOfPayment);
                        order.setDateOfDelivery(dateOfDelivery);
                        order.setSpecialInstructions(specialInstructions);
                        order.setOrderStatus(orderStatus);
                        order.setNumsOfAddOns(numsOfAddOns);
                        order.setAddOnsList(addOns);

                        order.updateContent();
                        ordersList.add(order);

                    } catch (Exception e) {
                        System.err.println("Failed to read file: " + file.getName());
                        e.printStackTrace();
                    }
                }
        sortByDateDescending();
    }

    public ArrayList<CheckOut> getAllOrders() {
        return ordersList;
    }

    public CheckOut viewMoreOrder(int index) {
        if (index < 0 || index >= ordersList.size()) return null;
        return ordersList.get(index);
    }

    public void sortByDateDescending() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy hh:mm a", Locale.ENGLISH);

        ordersList.sort(new Comparator<CheckOut>() {
            @Override
            public int compare(CheckOut o1, CheckOut o2) {
                try {
                    String dateStr1 = o1.getFormattedDate();
                    String dateStr2 = o2.getFormattedDate();
                    LocalDateTime date1 = LocalDateTime.parse(dateStr1, formatter);
                    LocalDateTime date2 = LocalDateTime.parse(dateStr2, formatter);
                    return date2.compareTo(date1);
                } catch (Exception e) {
                    return o2.getOrderID().compareTo(o1.getOrderID());
                }
            }
        });
    }
}