package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewOrdersPanel {
    JPanel viewOrdersPanel;
    private JPanel Header;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel Body;
    private JPanel North;
    private JPanel West;
    private JPanel South;
    private JPanel East;
    private JPanel Order;
    private JScrollPane Scrikk;
    private JLabel LeftImg;
    private JLabel RightImg;
    private JPanel LeftSouth;
    private JPanel RightSouth;
    private JButton prevButton;
    private JPanel orderDisplay;
    private UserController controller;

    public ViewOrdersPanel(){
        ImageIcon img = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Doggos.png");
        Image imgg =  img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon set = new ImageIcon(imgg);
        LeftImg.setIcon(set);
        LeftImg.setText("");
        RightImg.setIcon(set);
        RightImg.setText("");

        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img5=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img5);
        prevButton.setIcon(prev);
        prevButton.setText("");
        prevButton.setOpaque(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setBorderPainted(false);
        prevButton.setFocusPainted(false);
        prevButton.setText("");
    }

    public void setController(UserController userController){
        this.controller = userController;
        displayOrders();;

    }

    public void displayOrders() {
        User user = controller.getUser();
        if (user == null) {
            System.err.println("No active user.");
            return;
        }

        if (orderDisplay == null) {
            System.err.println("ordersContainer is null.");
            return;
        }

        orderDisplay.removeAll();
        orderDisplay.setLayout(
                new BoxLayout(orderDisplay, BoxLayout.Y_AXIS));

        for (CheckOut order : user.getOrders()) {

            String status = order.getOrderStatus();
            if (status == null || !status.equalsIgnoreCase("Complete"))
                continue;

            OrderCardPanel card = new OrderCardPanel(order, controller);

            orderDisplay.add(card);
            orderDisplay.add(Box.createVerticalStrut(15));
        }

        orderDisplay.revalidate();
        orderDisplay.repaint();
    }



}
