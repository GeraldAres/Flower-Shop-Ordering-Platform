package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class OrderCardPanel extends JPanel {

    public OrderCardPanel(CheckOut order, UserController controller) {

        setPreferredSize(new Dimension(900, 200));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        setBackground(Color.decode("#F4E6D8"));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        setLayout(new BorderLayout());

        // LEFT
        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel dateLabel = new JLabel(order.getOrderDateForCard());
        dateLabel.setFont(new Font("Bell MT", Font.BOLD, 26));
        dateLabel.setForeground(Color.decode("#561C32"));

        JLabel statusLabel = new JLabel("status: " + order.getOrderStatus());
        statusLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
        statusLabel.setForeground(Color.decode("#561C32"));

        left.add(dateLabel);
        left.add(Box.createVerticalStrut(6));
        left.add(statusLabel);

        // RIGHT
        JPanel right = new JPanel(new GridBagLayout());
        right.setOpaque(false);

        JLabel viewOrder = new JLabel("view order");
        viewOrder.setFont(new Font("Bell MT", Font.BOLD, 16));
        viewOrder.setForeground(Color.decode("#561C32"));
        viewOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        viewOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.openViewOrder(order);
            }
        });

        right.add(viewOrder);

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
    }
}
