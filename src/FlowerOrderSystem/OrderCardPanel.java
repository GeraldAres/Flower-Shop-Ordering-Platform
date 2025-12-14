package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderCardPanel extends JPanel {

    public OrderCardPanel(CheckOut order, UserController controller) {

        setPreferredSize(new Dimension(900, 200));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        setBackground(Color.decode("#F4E6D8"));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        setLayout(new BorderLayout());

        // Left
        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel dateLabel = new JLabel(order.getOrderDateForCard());
        dateLabel.setFont(new Font("Bell MT", Font.BOLD, 26));
        dateLabel.setForeground(Color.decode("#561C32"));
        dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        String timeText = "";
        String rawDate = order.getFormattedDate();

        if (rawDate != null) {
            Pattern timePattern = Pattern.compile("(\\d{1,2}:\\d{2}\\s?[a-zA-Z]{2})");
            Matcher matcher = timePattern.matcher(rawDate);
                if (matcher.find()) {
                    timeText = "Order made at " + matcher.group(1);
                }
        }

        JLabel timeLabel = new JLabel(timeText);
        timeLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
        timeLabel.setForeground(Color.decode("#561C32")); // Same color as date
        timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel statusLabel = new JLabel("status: " + order.getOrderStatus());
        statusLabel.setFont(new Font("Bell MT", Font.PLAIN, 16));
        statusLabel.setForeground(Color.decode("#561C32"));
        statusLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        left.add(dateLabel);
            if (!timeText.isEmpty()) {
                left.add(Box.createVerticalStrut(5)); // Small gap
                left.add(timeLabel);
            }
        left.add(Box.createVerticalStrut(30)); // Gap before status
        left.add(statusLabel);

        // Right
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