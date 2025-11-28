package src.FlowerOrderSystem;

import java.util.*;
import java.io.*;

public class ViewOrder {
    private ArrayList<CheckOut> ordersList = new ArrayList<>();

    public void loadFromFile(String filename) {
        File file = new File(filename);
            if (!file.exists()) {
                System.out.println("No previous order file found.");
                return;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split("\\|");
                            if (data.length == 5) {
                                String orderId = data[0];
                                String customerName = data[1];
                                String flower = data[2];
                                double total = Double.parseDouble(data[3]);
                                String date = data[4];

                                CheckOut order = new CheckOut(orderId, customerName, flower, total, date);
                                ordersList.add(order);
                            }
                    }
            } catch (IOException e) {
                System.out.println("Error reading orders file: " + e.getMessage());
            }
    }

    public ArrayList<CheckOut> getAllOrders() {
        return ordersList;
    }

    public CheckOut viewMoreOrder(int index) {
        if (index < 0 || index >= ordersList.size()) {
            return null;
        }
        return ordersList.get(index);
    }

    public void sortByDateDescending() {
        ordersList.sort((a, b) -> b.getFormattedDate().compareTo(a.getFormattedDate()));
    }
}