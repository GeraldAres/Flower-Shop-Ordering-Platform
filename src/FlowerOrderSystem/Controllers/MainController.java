package src.FlowerOrderSystem.Controllers;
import src.FlowerOrderSystem.*;

public class MainController implements Controller {
    private final MainPanel main;
    private  UserController setup;
    private  OrderController orderController;
    private CheckoutController checkoutController;
    private SignUpPanel signUpPanel;
    private User activeUser;
    private Order order;
    private boolean controlStatus;
    private CheckOut selectedOrder;

    public MainController(MainPanel main) {
        this.main = main;
        setup = new UserController(this);
        orderController = new OrderController(this);
        controlStatus = true;
    }

    public void changeDisplay(String action) throws InvalidInputException {
        if (action.equals("Guest")) {
            order = orderController.getOrder();
            main.getCardLayout().show(main.getMainPanel(), "Guest");
            main.getGuestOrderPanel().setUserController(setup);
            activeUser = setup.userFactory(action);
        }
        if (action.equals("Regular")) {
            main.getLogInPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "LogInPanel");
        }
        if (action.equals("ForgotPass")) {
            main.getForgotPassPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "Settings");
        }
        if (action.equals("Logout")) {
            main.getLogInPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "LogInPanel");
            activeUser = null;
        }

        if (action.equals("SignUp")){
            main.getSignUpPanel().setController(setup);
            main.getCardLayout().show(main.getMainPanel(), "SignUpPanel");
        }

        if (action.equals("Dashboard")) {
            main.getCardLayout().show(main.getMainPanel(), "Dashboard");
            main.getDashboardPanel().setController(this);
        };

        if (action.equals("LoggedIn")){
            activeUser = setup.getUser();
            main.getCardLayout().show(main.getMainPanel(), "Dashboard");
            main.getDashboardPanel().setController(this);
        }

        if (action.equals("NewOrder")){
            order = orderController.getOrder();
            main.getCardLayout().show(main.getMainPanel(), "NewOrder");
            main.getOrderPanel().setController (this);
        }


        if(action.equals("MyOrders")){
            main.getViewOrderPanel().setController(setup);
            main.getViewOrderPanel().displayOrders(activeUser);
            main.getCardLayout().show(main.getMainPanel(), "MyOrders" +
                    "");
        }
        if (action.equals("Settings")){
            main.getCardLayout().show(main.getMainPanel(), "Settings");
        }
        if(action.equals("Flowers")){
            main.getCardLayout().show(main.getMainPanel(), "Flowers");
        }
        if (action.equals("prev")){
            main.getCardLayout().show(main.getMainPanel(), "FirstPage");
        }

        if (action.equals("Stem")){
            main.getStemPanel().setController(orderController);
            main.getCardLayout().show(main.getMainPanel(), "StemPanel");
        }

        if (action.equals("StemBack") || action.equals("BouquetBack")){
            main.getCardLayout().show(main.getMainPanel(), "NewOrder");
        }

        if (action.equals("Bouquet")){
            main.getBouquetPanel().setController(orderController);
            main.getCardLayout().show(main.getMainPanel(), "Bouquet");
        }

        if (action.equals("Checkout")){
           checkoutController = new CheckoutController(activeUser, order, this);
            main.getCheckoutPanel().setOrderController(checkoutController);
            main.getCardLayout().show(main.getMainPanel(), "Checkout");
        }

        if(action.equals("Small")){
            main.getSmallBouquet().setController(orderController, 0);
            main.getCardLayout().show(main.getMainPanel(), "Small");
        }

        if(action.equals("SmallBack")){
            main.getCardLayout().show(main.getMainPanel(), "Bouquet");
        }

        if(action.equals("Medium")){
            main.getSmallBouquet().setController(orderController, 1);
            main.getCardLayout().show(main.getMainPanel(), "Small");
//            main.getMediumBouquet().setController(orderController);
//            main.getCardLayout().show(main.getMainPanel(), "Medium");
        }

        if(action.equals("MediumBack")){
            main.getCardLayout().show(main.getMainPanel(), "Bouquet");
        }

        if(action.equals("Large")){
            main.getSmallBouquet().setController(orderController, 2);
            main.getCardLayout().show(main.getMainPanel(), "Small");
//            main.getLargeBouquet().setController(orderController);
//            main.getCardLayout().show(main.getMainPanel(), "Large");
        }

        if(action.equals("LargeBack")){
            main.getCardLayout().show(main.getMainPanel(), "Bouquet");
        }

        if(action.equals("available1")){
            main.getFlowerCatPnl1().setOrderController(orderController);
            main.getCardLayout().show(main.getMainPanel(), "available1");
        }
        if(action.equals("available2")){
            main.getFlowerCatPnl2().setController(orderController);
            main.getCardLayout().show(main.getMainPanel(), "available2");
        }
        if(action.equals("available3")){
            main.getFlowerCatPnl3().setController(orderController);
            main.getCardLayout().show(main.getMainPanel(), "available3");

        }


    }

    public String getName(){
        if (activeUser != null) {
            String fullName = activeUser.getFullName().trim();
            return fullName.split(" ")[0];
        }
       return "Amigo";
    }

    public User getUser(){
        return activeUser;
    }

    public Order getOrder(){
        return order;
    }


    @Override
    public boolean isControlling() {
        return controlStatus;
    }

    public void setSelectedOrder(CheckOut order) {
        this.selectedOrder = order;
    }

    public CheckOut getSelectedOrder() {
        return selectedOrder;
    }

    public void setUser(User user) {
        activeUser = user;
    }
}
