package src.FlowerOrderSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    JPanel MainPanel;
    CardLayout cardLayout = new CardLayout();
    private JPanel FirstPage;
    private JButton btnLogIn;
    private JButton btnGuest;
    private JLabel Logo;
    private JPanel BusinessName;
    private final Action action;
    private ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Hiraya.png");
    private Image img = image1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    private ImageIcon scaledIcon = new ImageIcon(img);


    public MainPanel() {
        MainPanel.setLayout(cardLayout);

        OrderPanel orderPanel = new OrderPanel(MainPanel, cardLayout);
        ViewOrderPanel viewOrderPanel = new ViewOrderPanel();
        StemPanel stemPanel = new StemPanel();
        BouquetPanel bouquetPanel = new BouquetPanel();
        LogInPanel logInPanel = new LogInPanel();

        MainPanel.add(FirstPage, "FirstPage");
        MainPanel.add(orderPanel.OrderPanel, "OrderPanel");
        MainPanel.add(viewOrderPanel.ViewOrderPanel, "ViewOrderPanel");
        MainPanel.add(stemPanel.StemPanel, "StemPanel" );
        MainPanel.add(bouquetPanel.BouquetPanel, "BouquetPanel");
        MainPanel.add(logInPanel.LogInPnl, "LogInPanel");

        action = new Action(MainPanel, cardLayout);


        Logo.setIcon(scaledIcon);
        Logo.setHorizontalTextPosition(JLabel.CENTER);
        Logo.setVerticalTextPosition(JLabel.CENTER);
        Logo.setIconTextGap(10);


        btnGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.performAction("Guest");
            }
        });

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.performAction("LogIn");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setContentPane(new MainPanel().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
