package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.OrderController;

import javax.swing.*;
import java.awt.*;
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

                switch(SizeField.getSelectedIndex()){
                    case 0:
                        try {
                            orderController.userActions("Small");
                        } catch (InvalidInputException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 1:
                        try {
                            orderController.userActions("Medium");
                        } catch (InvalidInputException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 2:
                        try {
                            orderController.userActions("Large");
                        } catch (InvalidInputException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                }
            }
        });

        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    orderController.userActions("BouquetBack");
                } catch (InvalidInputException ex ) {
                    throw new RuntimeException(ex);
                }
            }
        });




    }


    bouquetFormSize(){
        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img);
        btnPrev.setIcon(prev);
        btnPrev.setText("");
        btnPrev.setOpaque(false);
        btnPrev.setContentAreaFilled(false);
        btnPrev.setBorderPainted(false);
        btnPrev.setFocusPainted(false);
        btnPrev.setText("");

        ImageIcon image6 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/nextBtn.png");
        Image img7 =  image6.getImage().getScaledInstance(110, 35, Image.SCALE_SMOOTH);
        ImageIcon nextBtn = new ImageIcon(img7);
        btnNext.setIcon(nextBtn);
        btnNext.setText("");
        btnNext.setOpaque(false);
        btnNext.setContentAreaFilled(false);
        btnNext.setBorderPainted(false);
        btnNext.setFocusPainted(false);
        btnNext.setText("");
        //for the checkoutBtn
    }
      static void main() {

        JFrame frame = new JFrame("Bouquet Order System");
        frame.setContentPane(new bouquetFormSize().Bouquet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
