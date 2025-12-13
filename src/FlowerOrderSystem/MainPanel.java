package src.FlowerOrderSystem;
import src.FlowerOrderSystem.Controllers.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JPanel MainPanel;
    private final CardLayout cardLayout = new CardLayout();
    private JPanel FirstPage;
    private JButton btnLogIn;
    private JButton btnGuest;
    private JLabel Logo;
    private JLabel ImageHolder2;
    private JLabel ImageHolder;
    private String action;
    private MainController controller;
    private  GuestOrderPanel guestOrderPanel = new GuestOrderPanel();
    private ViewOrdersPanel viewOrders = new ViewOrdersPanel();
    private StemPanel stemPanel = new StemPanel();
    private bouquetFormSize bouquetPanel = new bouquetFormSize();
    private  LogInPanel logInPanel = new LogInPanel();
    private  DashboardPanel dashboardPanel = new DashboardPanel();
    private SignUpPanel signUpPanel = new SignUpPanel();
    private OrderPanel order = new OrderPanel();
    private ForgotPassPanel forgotPassPanel = new ForgotPassPanel();
    private CheckoutPanel checkoutPanel = new CheckoutPanel();

    public MainPanel() throws InvalidInputException, NullPointerException {
        // The following code sets up the card layout, allowing the Main Controller to easily switch through screens //
        MainPanel.setLayout(cardLayout);
        MainPanel.add(FirstPage, "FirstPage");
        MainPanel.add(guestOrderPanel.GuestOrder, "Guest");
        MainPanel.add(viewOrders.viewOrdersPanel, "MyOrders");
        MainPanel.add(stemPanel.StemPanel, "StemPanel" );
        MainPanel.add(bouquetPanel.Bouquet, "Bouquet");
        MainPanel.add(logInPanel.LogInPnl, "LogInPanel");
        MainPanel.add(dashboardPanel.Dashboard, "Dashboard");
        MainPanel.add(signUpPanel.SignUpPnl, "SignUpPanel");
        MainPanel.add(order.orderPanel, "NewOrder");
        MainPanel.add(forgotPassPanel.ForgotPassPnl, "Settings");
        MainPanel.add(checkoutPanel.checkoutPanel, "CheckoutPanel");


        // Sets the business logo up for display //

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/HirayaCebu.png");
        Image img = image1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        Logo.setIcon(scaledIcon);
        Logo.setHorizontalTextPosition(JLabel.CENTER);
        Logo.setVerticalTextPosition(JLabel.CENTER);
        Logo.setIconTextGap(10);

        //Sets up the border images of the design //

        ImageIcon pic = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Accessories.png");
        Image imgg =  pic.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon set = new ImageIcon(imgg);
        ImageHolder.setIcon(set);
        ImageHolder2.setIcon(set);
        ImageHolder.setText("");
        ImageHolder2.setText("");

        // Guest option//

        btnGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   try{
                       controller.changeDisplay("Guest");
                   } catch (InvalidInputException ex) {
                       JOptionPane.showMessageDialog(MainPanel,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                   }

            }
        });

        // Login option//

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.changeDisplay("Regular");
                } catch (InvalidInputException ex) {
                    JOptionPane.showMessageDialog(MainPanel,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public CardLayout getCardLayout() {
            return cardLayout;
    }

    public String getAction(){
        return action;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }
    public LogInPanel getLogInPanel() {
        return logInPanel;
    }

    public SignUpPanel getSignUpPanel() {
        return signUpPanel;
    }

    public DashboardPanel getDashboardPanel() {
        return dashboardPanel;
    }

    public bouquetFormSize getBouquetPanel() {
        return bouquetPanel;
    }
    public  GuestOrderPanel getGuestOrderPanel() {
        return guestOrderPanel;
    }
    public ViewOrdersPanel getViewOrderPanel() {
        return viewOrders;
    }
    public StemPanel getStemPanel() {
        return stemPanel;
    }
    public OrderPanel getOrderPanel() {
        return order;
    }
    public  ForgotPassPanel getForgotPassPanel() {
        return forgotPassPanel;
    }

    public CheckoutPanel getCheckoutPanel() {
        return checkoutPanel;
    }
}
