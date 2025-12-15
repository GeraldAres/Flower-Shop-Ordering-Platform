package src.FlowerOrderSystem;

import java.io.*;
import java.util.*;

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
                    String line;
                    HashMap<String, String> data = new HashMap<>();
                    ArrayList<String> loadedItems = new ArrayList<>();
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("\t")) {
                                loadedItems.add(line.trim());
                                continue;
                            }

                            if (line.contains(":")) {
                                String[] parts = line.split(":", 2);
                                    if (parts.length == 2) {
                                        data.put(parts[0].trim(), parts[1].trim());
                                    }
                            }
                        }

                    String orderId = data.getOrDefault("Order ID", "Unknown");
                    String orderDate = data.getOrDefault("Order Date", "Unknown");
                    String priceStr = data.getOrDefault("Total Price", "0")
                            .replaceAll("[^0-9.]", "");

                    double totalPrice = 0.0;

                        try {
                            totalPrice = Double.parseDouble(priceStr);
                        } catch (NumberFormatException e) {
                            totalPrice = 0.0;
                        }

                    CheckOut order = new CheckOut(orderId, null, null, totalPrice, orderDate);

                        order.setModeOfDelivery(data.get("Mode of Delivery"));
                        order.setAddressOfDelivery(data.get("Address of Delivery"));
                        order.setModeOfPayment(data.get("Mode of Payment"));
                        order.setDateOfDelivery(data.get("Date of Delivery"));
                        order.setSpecialInstructions(data.get("Special Instructions"));
                        order.setOrderStatus(data.get("Order Status"));

                        try {
                            order.setNumsOfAddOns(Integer.parseInt(data.getOrDefault("Number of Add-Ons", "0")));
                        } catch (NumberFormatException e) {
                            order.setNumsOfAddOns(0);
                        }

                    ArrayList<String> addOns = new ArrayList<>();
                    String listRaw = data.get("Add-Ons List");

                        if (listRaw != null && !listRaw.equals("None")) {
                            listRaw = listRaw.replace("[", "").replace("]", "");
                                if (!listRaw.isBlank()) {
                                    String[] items = listRaw.split(",");
                                        for (String s : items) {
                                            addOns.add(s.trim());
                                        }
                                }
                        }

                        order.setAddOnsList(addOns);
                        order.setOrderItems(loadedItems);
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
        ordersList.sort((o1, o2) -> {
                String id1 = o1.getOrderID();
                String id2 = o2.getOrderID();
            return id2.compareTo(id1);
        });
    }
}