package src;

import javax.swing.*;

public class Flower {
    private JPanel MainPanel;
    private JPanel ActionPanel;
    private JPanel TitlePanel;
    private JButton btnViewOrder;
    private JButton btnNewOrder;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setContentPane(new Flower().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
