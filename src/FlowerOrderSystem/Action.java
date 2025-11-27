package src.FlowerOrderSystem;
import javax.swing.*;
import java.awt.*;

public class Action {
    private  String action = null;
    private final JPanel mainPanel;
    private final CardLayout layout;


    public Action(JPanel mainPanel, CardLayout layout) {
        this.mainPanel = mainPanel;
        this.layout = layout;
    }

    public void performAction(String action){
        this.action = action;
        if (action == null) return;

        if (action.equalsIgnoreCase("Guest")){
           layout.show(mainPanel, "OrderPanel");

        } else {
            /* call viewOrders panel and hide firstPanel */
            layout.show(mainPanel, "LogInPanel");
        }
    }

    public String getAction() {
        return action;
    }

}
