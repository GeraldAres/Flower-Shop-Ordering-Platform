package src.FlowerOrderSystem;

import javax.swing.*;
import javax.swing.text.View;

public class ViewOrderPanel {
     JPanel ViewOrderPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setContentPane(new ViewOrderPanel().ViewOrderPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}



