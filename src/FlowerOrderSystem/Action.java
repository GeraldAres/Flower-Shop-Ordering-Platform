package src.FlowerOrderSystem;

public class Action {
    private String action;

    public Action(String action){
        this.action = action;
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
}
