package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StemPanel {
    JPanel StemPanel;
    private JPanel FlowersPanel;

    private JLabel roseQuantityIncrease;
    private JLabel roseQuantityDecrease;

    private JLabel carnationQuantityIncrease;
    private JLabel carnationQuantityDecrease;

    private JLabel lilyQuantityIncrease;
    private JLabel lilyQuantityDecrease;

    private JLabel daisyQuantityIncrease;
    private JLabel daisyQuantityDecrease;

    private JLabel sunflowerQuantityIncrease;
    private JLabel sunflowerQuantityDecrease;

    private JLabel tulipQuantityIncrease;
    private JLabel tulipQuantityDecrease;

    private JButton previousButton;
    private JButton nextButton;

    private JLabel roseFlower;
    private JLabel carnationFlower;
    private JLabel daisyFlower;
    private JLabel lilyFlower;
    private JLabel sunflowerFlower;
    private JLabel tulipFlower;

    private JLabel roseCount;
    private JLabel carnationCount;
    private JLabel daisyCount;
    private JLabel lilyCount;
    private JLabel sunflowerCount;
    private JLabel tulipCount;
    private JLabel totalPrice;

    private Order order = new Order("Stem");



    public StemPanel() {
        // Load the image
        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/flower.jpeg");

        // Optional: scale the image to fit nicely
        Image img = image1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        roseFlower.setIcon(scaledIcon);
        roseFlower.setHorizontalTextPosition(JLabel.RIGHT);
        roseFlower.setVerticalTextPosition(JLabel.CENTER);
        roseFlower.setIconTextGap(10);

        carnationFlower.setIcon(scaledIcon);
        carnationFlower.setHorizontalTextPosition(JLabel.RIGHT);
        carnationFlower.setVerticalTextPosition(JLabel.CENTER);
        carnationFlower.setIconTextGap(10);

        daisyFlower.setIcon(scaledIcon);
        daisyFlower.setHorizontalTextPosition(JLabel.RIGHT);
        daisyFlower.setVerticalTextPosition(JLabel.CENTER);
        daisyFlower.setIconTextGap(10);

        lilyFlower.setIcon(scaledIcon);
        lilyFlower.setHorizontalTextPosition(JLabel.RIGHT);
        lilyFlower.setVerticalTextPosition(JLabel.CENTER);
        lilyFlower.setIconTextGap(10);

        sunflowerFlower.setIcon(scaledIcon);
        sunflowerFlower.setHorizontalTextPosition(JLabel.RIGHT);
        sunflowerFlower.setVerticalTextPosition(JLabel.CENTER);
        sunflowerFlower.setIconTextGap(10);

        tulipFlower.setIcon(scaledIcon);
        tulipFlower.setHorizontalTextPosition(JLabel.RIGHT);
        tulipFlower.setVerticalTextPosition(JLabel.CENTER);
        tulipFlower.setIconTextGap(10);

        Stem rose = new Rose("red");
        Stem carnation = new Carnation("red");
        Stem daisy = new Daisy("red");
        Stem lily = new Lily("red");
        Stem sunflower = new Sunflower("red");
        Stem tulip = new Tulip("red");

        roseQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(roseCount.getText()) + 1;

//                Stem rose = new Rose("red");

                order.addFlower(rose);

                order.setPrice();

                totalPrice.setText(order.getOrderPrice() + "");

                roseCount.setText(c + "");
            }
        });

        roseQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(roseCount.getText()) ;

                if(c > 0){
                    c -= 1;

                    order.removeFlower(rose);

                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");

                }

                roseCount.setText(c + "");
            }
        });

        carnationQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(carnationCount.getText()) + 1;

                order.addFlower(carnation);
                order.setPrice();

                totalPrice.setText(order.getOrderPrice() + "");

                carnationCount.setText(c + "");
            }
        });

        carnationQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(carnationCount.getText()) ;

                if(c > 0){
                    c -= 1;
                    order.removeFlower(carnation);

                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");
                }

                carnationCount.setText(c + "");
            }
        });

        daisyQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(daisyCount.getText()) + 1;

                order.addFlower(daisy);
                order.setPrice();

                totalPrice.setText(order.getOrderPrice() + "");

                daisyCount.setText(c + "");
            }
        });

        daisyQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(daisyCount.getText()) ;

                if(c > 0){
                    c -= 1;

                    order.removeFlower(daisy);

                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");
                }

                daisyCount.setText(c + "");
            }
        });

        lilyQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(lilyCount.getText()) + 1;

                order.addFlower(lily);
                order.setPrice();

                totalPrice.setText(order.getOrderPrice() + "");

                lilyCount.setText(c + "");
            }
        });

        lilyQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(lilyCount.getText()) ;

                if(c > 0){
                    c -= 1;

                    order.removeFlower(lily);

                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");
                }

                lilyCount.setText(c + "");
            }
        });

        sunflowerQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(sunflowerCount.getText()) + 1;

                order.addFlower(sunflower);
                order.setPrice();

                totalPrice.setText(order.getOrderPrice() + "");

                sunflowerCount.setText(c + "");
            }
        });

        sunflowerQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(sunflowerCount.getText()) ;

                if(c > 0){
                    c -= 1;

                    order.removeFlower(sunflower);

                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");
                }

                sunflowerCount.setText(c + "");
            }
        });

        tulipQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(tulipCount.getText()) + 1;

                order.addFlower(tulip);
                order.setPrice();

                totalPrice.setText(order.getOrderPrice() + "");

                tulipCount.setText(c + "");
            }
        });

        tulipQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(tulipCount.getText()) ;

                if(c > 0){
                    c -= 1;

                    order.removeFlower(tulip);

                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");
                }

                tulipCount.setText(c + "");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new StemPanel().StemPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.pack();
        frame.setVisible(true);
    }
}


