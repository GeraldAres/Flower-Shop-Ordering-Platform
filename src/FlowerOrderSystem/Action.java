package src.FlowerOrderSystem;
import javax.swing.*;
import java.awt.*;

public class Action {
    private  String action;
    private JPanel mainPanel;
    private CardLayout layout;


    public Action(JPanel mainPanel, CardLayout layout) {
        this.mainPanel = mainPanel;
        this.layout = layout;
    }

    public void performAction(){
        if (action == null) return;

        if (action.equalsIgnoreCase("New Order")){
            NewForm newForm = new NewForm();
            /* call viewOrders panel and hide firstPanel */
        } else {
            /* call viewOrders panel and hide firstPanel */
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
