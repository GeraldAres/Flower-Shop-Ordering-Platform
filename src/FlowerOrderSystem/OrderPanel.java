package src.FlowerOrderSystem;

import javax.swing.*;

public class OrderPanel {
    JPanel OrderPanel;
    private JPanel InputArea;
    private JLabel BrandName;
    private JTextField a63TextField;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel ServicesBtn;
    private JButton stemButton;
    private JButton bouquetButton;
    private JButton btnPrevious;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new OrderPanel().OrderPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
