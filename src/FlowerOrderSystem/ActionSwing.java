package src.FlowerOrderSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSwing {
    private JPanel MainPanel;
    private JPanel FirstPage;
    CardLayout cardLayout = new CardLayout();
    private JButton btnViewOrder;
    private JButton btnNewOrder;
    private JLabel Logo;
    private final Action action;
    private OrderPanel orderPanel = new OrderPanel();
    private ViewOrderPanel viewOrderPanel = new ViewOrderPanel();
    ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Images/flower.jpeg");
    Image img = image1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(img);


    public ActionSwing() {
        Logo.setIcon(scaledIcon);
        Logo.setHorizontalTextPosition(JLabel.CENTER);
        Logo.setVerticalTextPosition(JLabel.CENTER);
        Logo.setIconTextGap(10);
        MainPanel.setLayout(cardLayout);
        MainPanel.add(FirstPage, "FirstPage");

        MainPanel.add(orderPanel.OrderPanel, "OrderPanel");
        MainPanel.add(viewOrderPanel.ViewOrderPanel, "ViewOrderPanel");
        action = new Action(MainPanel, cardLayout);
        btnNewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.performAction("New Order");
            }
        });

        btnViewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.performAction("View Order");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setContentPane(new ActionSwing().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
