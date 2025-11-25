package src.FlowerOrderSystem;
import src.FlowerOrderSystem.Action;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSwing {
    private JPanel MainPanel;
    CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
    private JPanel ActionPanel;
    private JPanel TitlePanel;
    private JButton btnViewOrder;
    private JButton btnNewOrder;
    private Action action = new Action(MainPanel, cardLayout);

    public ActionSwing() {
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
