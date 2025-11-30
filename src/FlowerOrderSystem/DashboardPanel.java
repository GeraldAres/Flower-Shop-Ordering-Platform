package src.FlowerOrderSystem;

import javax.swing.*;

public class DashboardPanel {
    private JPanel Dashboard;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel MainDashboard;
    private JPanel WelcomePanel;
    private JPanel ButtonsList;
    private JButton newOrderButton;
    private JButton prevButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new DashboardPanel().Dashboard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
