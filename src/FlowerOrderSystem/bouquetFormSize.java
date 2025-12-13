package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.OrderController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bouquetFormSize {
    JPanel Bouquet;
    private JPanel Holder;
    private JPanel SouthPanel;
    private JLabel SizeLabel;
    private JComboBox SizeField;
    private JLabel wrpColorLabel;
    private JComboBox wrpColorField;
    private JButton btnNext;
    private JButton btnPrev;
    private JPanel NorthPanel;
    private JLabel brandTitle1;
    private JLabel subTitle1;

    private OrderController orderController;

    public void setController(OrderController orderController){
        this.orderController = orderController;

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    orderController.userActions("Small");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }

    static void main() {
        JFrame frame = new JFrame("Bouquet Order System");
        frame.setContentPane(new bouquetFormSize().Bouquet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
