package src.FlowerOrderSystem;
import javax.swing.*;
import java.awt.*;

public class Action {
    private  String action = " ";
    private JPanel mainPanel;
    private CardLayout layout;


    public Action(JPanel mainPanel, CardLayout layout) {
        this.mainPanel = mainPanel;
        this.layout = layout;
    }

    public void performAction(){
        if (action == " ") return;

        if (action.equalsIgnoreCase("New Order")){
           layout.show(mainPanel, "OrderPanel");

        } else {
            /* call viewOrders panel and hide firstPanel */
            layout.show(mainPanel, "MainPanel");
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
