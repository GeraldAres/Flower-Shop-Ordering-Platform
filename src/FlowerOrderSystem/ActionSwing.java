package src.FlowerOrderSystem;
import src.FlowerOrderSystem.Action;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSwing {
    private JPanel MainPanel;
    CardLayout cardLayout = new CardLayout();
    private JPanel ActionPanel;
    private JPanel TitlePanel;
    private JButton btnViewOrder;
    private JButton btnNewOrder;
    final Action action;

    public ActionSwing() {
        MainPanel.setLayout(cardLayout);
        OrderPanel orderPanel = new OrderPanel();
        MainPanel.add(orderPanel.OrderPanel, "OrderPanel");
        action = new Action(MainPanel, cardLayout);
        btnNewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.setAction("New Order");
            }
        });

        btnViewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.setAction("View Order");
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
