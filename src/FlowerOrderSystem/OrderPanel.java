package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderPanel {
    JPanel OrderPanel;
    private JPanel InputArea;
    private JLabel BrandName;
    private JTextField userContactNumber;
    private JTextField userAddress;
    private JTextField userName;
    private JPanel ServicesBtn;
    private JButton stemButton;
    private JButton bouquetButton;
    private JButton btnPrevious;
    private JLabel invalidNameLbl;
    private JLabel invalidAddressLbl;
    private JLabel invalidContactLbl;


    public OrderPanel() {
        src.FlowerOrderSystem.NewForm  newForm = new NewForm();
        stemButton.setEnabled(false);
        bouquetButton.setEnabled(false);
        invalidNameLbl.setVisible(false);
        invalidAddressLbl.setVisible(false);
        invalidContactLbl.setVisible(false);

        int ContactNumber = Integer.parseInt(userContactNumber.getText());
        newForm.createUser(userName.getText(), userAddress.getText(), ContactNumber);
        stemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newForm.createOrder("Stem");
            }
        });

    }
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
