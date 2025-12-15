package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.CheckoutController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrderDetails {
     JPanel OrderDetailsPnl;
    private JPanel container;
    private JPanel header;
    private JPanel center;
    private JPanel left;
    private JPanel Personal;
    private JPanel orderInfo;
    private JPanel OrdersHere;
    private JPanel PersonalInformation;
    private JLabel customerName;
    private JLabel contactNumber;
    private JLabel email;
    private JPanel AddOns;
    private JLabel fereroPrice;
    private JLabel labubuPrice;
    private JLabel tobleronPrice;
    private JLabel teddyBearPrice;
    private JPanel orderSummaryPanel;
    private JPanel right;
    private JLabel totalPrice;
    private JButton cancelBtn;
    private JLabel delivery;
    private JLabel payment;
    private JLabel address;
    private JLabel date;
    private JLabel receiver;
    private JLabel specialInstruction;
    private JPanel SampleOrderDetailsPnl;
    private CheckoutController controller;



    public void  setController(CheckoutController controller) {
        this.controller = controller;
        customerName.setText(controller.getName());
        contactNumber.setText(controller.getNumber());
        email.setText(controller.getEmail());
        delivery.setText(controller.getCheckout().getModeOfDelivery());
        payment.setText(controller.getCheckout().getModeOfPayment());
        address.setText(controller.getCheckout().getAddressOfDelivery());
        date.setText(controller.getCheckout().getDateOfDelivery());
        receiver.setText(controller.getCheckout().getReceipientName());
        specialInstruction.setText(controller.getCheckout().getSpecialInstructions());
        orderSummaryPanel.setLayout(new BoxLayout(orderSummaryPanel, BoxLayout.Y_AXIS));
        orderSummaryPanel.removeAll();

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/checkoutBtn.png");
        Image img1 =  image1.getImage().getScaledInstance(110, 35, Image.SCALE_SMOOTH);
        ImageIcon Checkoutbtn = new ImageIcon(img1);
        cancelBtn.setIcon(Checkoutbtn);
        cancelBtn.setText("");
        cancelBtn.setOpaque(false);
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setText("");


        ArrayList<String> lines = controller.getOrderSummaryLines(); // only plain Strings

        for (String text : lines) {
            JLabel label = new JLabel(text);
            label.setFont(new Font("Bell MT", Font.PLAIN, 20));
            label.setForeground(Color.decode("#561C32"));
            orderSummaryPanel.add(label);
        }

        totalPrice.setText( String.format("%.2f", controller.getOrderTotalPrice()));
        orderSummaryPanel.revalidate();
        orderSummaryPanel.repaint();
    }

}
