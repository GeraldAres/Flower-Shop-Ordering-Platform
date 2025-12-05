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
    private JLabel ImageHolder2;
    private JLabel ImageHolder;

    public MainPanel() throws InvalidInputException {
        MainPanel.setLayout(cardLayout);

        GuestOrderPanel newFormSample = new GuestOrderPanel(MainPanel, cardLayout);
        ViewOrderPanel viewOrderPanel = new ViewOrderPanel();
        StemPanel stemPanel = new StemPanel();
        BouquetPanel bouquetPanel = new BouquetPanel();
        LogInPanel logInPanel = new LogInPanel(MainPanel, cardLayout);
        DashboardPanel dashboardPanel = new DashboardPanel(MainPanel, cardLayout);
        SignUpPanel signUpPanel = new SignUpPanel(MainPanel, cardLayout);

        MainPanel.add(FirstPage, "FirstPage");
        MainPanel.add(newFormSample.GuestOrder, "Guest");
        MainPanel.add(viewOrderPanel.ViewOrderPanel, "ViewOrderPanel");
        MainPanel.add(stemPanel.StemPanel, "StemPanel" );
        MainPanel.add(bouquetPanel.BouquetPanel, "BouquetPanel");
        MainPanel.add(logInPanel.LogInPnl, "LogInPanel");
        MainPanel.add(dashboardPanel.Dashboard, "Dashboard");
        MainPanel.add(signUpPanel.SignUpPnl, "SignUpPanel");

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/HirayaCebu.png");
        Image img = image1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        Logo.setIcon(scaledIcon);
        Logo.setHorizontalTextPosition(JLabel.CENTER);
        Logo.setVerticalTextPosition(JLabel.CENTER);
        Logo.setIconTextGap(10);


        btnGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainPanel, "Guest");
            }
        });

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainPanel, "LogInPanel");
            }
        });

        ImageIcon pic = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Accessories.png");
        Image imgg =  pic.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon set = new ImageIcon(imgg);
        ImageHolder.setIcon(set);
        ImageHolder2.setIcon(set);
        ImageHolder.setText("");
        ImageHolder2.setText("");
    }



}
