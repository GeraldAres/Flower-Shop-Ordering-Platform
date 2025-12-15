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
    private BouquetOrderForm smallBouquet = new BouquetOrderForm();
    private BouquetMediumPanel mediumBouquet = new BouquetMediumPanel();
    private BouquetLargePanel largeBouquet =  new BouquetLargePanel();
    private OrderDetails orderDetails = new OrderDetails();

    private FlowerCat_Pnl1 flowerCatPnl1 = new FlowerCat_Pnl1();
    private FlowerCat_Pnl2 flowerCatPnl2 = new FlowerCat_Pnl2();
    private FlowerCat_Pnl3 flowerCatPnl3 = new FlowerCat_Pnl3();

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
        MainPanel.add(checkoutPanel.checkoutPanel, "Checkout");
        MainPanel.add(smallBouquet.Bouquet, "Small");
        MainPanel.add(mediumBouquet.Bouquet, "Medium");
        MainPanel.add(largeBouquet.Bouquet, "Large");
        MainPanel.add(orderDetails.OrderDetailsPnl, "viewThis");

        // Sets the business logo up for display //

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/HirayaCebu.png");
        Image img = image1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        Logo.setIcon(scaledIcon);
        Logo.setHorizontalTextPosition(JLabel.CENTER);
        Logo.setVerticalTextPosition(JLabel.CENTER);
        Logo.setIconTextGap(10);

        //Sets up the border images of the design //

        ImageIcon pic = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Accessories.png");
        Image imgg =  pic.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon set = new ImageIcon(imgg);
        ImageHolder.setIcon(set);
        ImageHolder2.setIcon(set);
        ImageHolder.setText("");
        ImageHolder2.setText("");

        ImageIcon image = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/LogIn.png");
        Image img1 =  image.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon login = new ImageIcon(img1);
        btnLogIn.setIcon(login);
        btnLogIn.setText("");
        btnLogIn.setOpaque(false);
        btnLogIn.setContentAreaFilled(false);
        btnLogIn.setBorderPainted(false);
        btnLogIn.setFocusPainted(false);
        btnLogIn.setText("");

        ImageIcon image2 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/Guess.png");
        Image img2 =  image2.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon guest = new ImageIcon(img2);
        btnGuest.setIcon(guest);
        btnGuest.setText("");
        btnGuest.setOpaque(false);
        btnGuest.setContentAreaFilled(false);
        btnGuest.setBorderPainted(false);
        btnGuest.setFocusPainted(false);
        btnGuest.setText("");

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

    public BouquetOrderForm getSmallBouquet() {
        return smallBouquet;
    }

    public BouquetLargePanel getLargeBouquet() {
        return largeBouquet;
    }

    public BouquetMediumPanel getMediumBouquet() {
        return mediumBouquet;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }
}
