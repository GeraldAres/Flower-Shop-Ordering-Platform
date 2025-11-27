package src.FlowerOrderSystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LogInPanel {
    JPanel LogInPnl;
    private JLabel Welcome;
    private JPanel Right;
    private JTextField username;
    private JTextField password;
    private JButton logInButton;

    public LogInPanel() {

        // ---------- Apply rounded text fields ----------
        username = new RoundedTextField(50);
        password = new RoundedTextField(50);

        // ---------- Apply rounded button ----------
        // Instead of just setting border, wrap existing button with paint override
        logInButton = new JButton("Log In") {
            private int radius = 30;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.GRAY);
                g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
                g2.dispose();
            }
        };

        logInButton.setBackground(Color.decode("#561C32")); // Marron
        logInButton.setForeground(Color.WHITE);
        logInButton.setFocusPainted(false);
        logInButton.setBorder(new RoundedBorder(30));
    }

    // ---------- Rounded border for button ----------
    static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) { this.radius = radius; }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        public boolean isBorderOpaque() { return false; }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawRoundRect(x, y, width-1, height-1, radius, radius);
            g2.dispose();
        }
    }

    // ---------- Rounded text field ----------
    static class RoundedTextField extends JTextField {
        private int radius = 85;

        public RoundedTextField(int columns) {
            super(columns);
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY);
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
            g2.dispose();
        }
    }

    // ---------- Main method ----------
    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new LogInPanel().LogInPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setVisible(true);
    }
}
