package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.OrderController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StemPanel {
    JPanel StemPanel;
    private JPanel Container;
    private JPanel Header;
    private JPanel Center;
    private JPanel left;
    private JPanel right;
    private JPanel leftside_left;
    private JPanel rightside_left;
    private JPanel leftside_right;
    private JPanel rightside_right;
    private JLabel roseStock;
    private JLabel lilyStock;
    private JLabel roseQuantityIncrease;
    private JLabel roseQuantityDecrease;
    private JLabel roseCount;
    private JLabel lilyQuantityIncrease;
    private JLabel lilyQuantityDecrease;
    private JLabel lilyCount;
    private JLabel sunflowerQuantityIncrease;
    private JLabel sunflowerQuantityDecrease;
    private JLabel sunflowerCount;
    private JLabel tulipCount;
    private JLabel tulipQuantityIncrease;
    private JLabel tulipQuantityDecrease;
    private JLabel carnationCount;
    private JLabel carnationQuantityIncrease;
    private JLabel carnationQuantityDecrease;
    private JLabel daisyCount;
    private JLabel daisyQuantityIncrease;
    private JLabel daisyQuantityDecrease;
    private JLabel sunflowerStock;
    private JLabel tulipStock;
    private JLabel carnationStock;
    private JLabel daisyStock;
    private JButton prevBtn;
    private JButton checkoutBtn;
    private JLabel totalPrice;
    private JPanel center_left;
    private JLabel roseFlower;
    private JLabel lilyFlower;
    private JLabel sunflowerFlower;
    private JPanel center_right;
    private JLabel tulipFlower;
    private JLabel carnationFlower;
    private JLabel daisyFlower;
    private JLabel RosePrice;
    private JLabel LilyPrice;
    private JLabel SunflowerPrice;
    private JLabel DaisyPrice;
    private JLabel CarnationPrice;
    private JLabel TulipPrice;
    private JLabel picture;
    private OrderController orderController;
    private Order order = new Order();
    private Inventory inventory = new Inventory();


    public StemPanel() {

        roseStock.setText(inventory.getStockCount("rose") + "");
        carnationStock.setText(inventory.getStockCount("carnation") + "");
        sunflowerStock.setText(inventory.getStockCount("sunflower") + "");
        daisyStock.setText(inventory.getStockCount("daisy") + "");
        lilyStock.setText(inventory.getStockCount("lily") + "");
        tulipStock.setText(inventory.getStockCount("tulip") + "");


        // Load the image
        ImageIcon roseImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Rose.png");
        ImageIcon carnationImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Carnation.png");
        ImageIcon daisyImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Daisy.png");
        ImageIcon lilyImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Lily.png");
        ImageIcon sunflowerImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Sunflower.png");
        ImageIcon tulipImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Tulip.png");

        // Optional: scale the image to fit nicely
        Image img1 = roseImage.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(img1);

        Image img2 = carnationImage.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(img2);

        Image img3 = daisyImage.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(img3);

        Image img4 = lilyImage.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(img4);

        Image img5 = sunflowerImage.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(img5);

        Image img6 = tulipImage.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(img6);


        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img);
        prevBtn.setIcon(prev);
        prevBtn.setText("");
        prevBtn.setOpaque(false);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setBorderPainted(false);
        prevBtn.setFocusPainted(false);
        prevBtn.setText("");


        roseFlower.setIcon(scaledIcon1);
        roseFlower.setHorizontalTextPosition(JLabel.RIGHT);
        roseFlower.setVerticalTextPosition(JLabel.CENTER);
        roseFlower.setIconTextGap(10);

        carnationFlower.setIcon(scaledIcon2);
        carnationFlower.setHorizontalTextPosition(JLabel.RIGHT);
        carnationFlower.setVerticalTextPosition(JLabel.CENTER);
        carnationFlower.setIconTextGap(10);

        daisyFlower.setIcon(scaledIcon3);
        daisyFlower.setHorizontalTextPosition(JLabel.RIGHT);
        daisyFlower.setVerticalTextPosition(JLabel.TOP);
        daisyFlower.setIconTextGap(50);

        lilyFlower.setIcon(scaledIcon4);
        lilyFlower.setHorizontalTextPosition(JLabel.RIGHT);
        lilyFlower.setVerticalTextPosition(JLabel.CENTER);
        lilyFlower.setIconTextGap(10);

        sunflowerFlower.setIcon(scaledIcon5);
        sunflowerFlower.setHorizontalTextPosition(JLabel.RIGHT);
        sunflowerFlower.setVerticalTextPosition(JLabel.CENTER);
        sunflowerFlower.setIconTextGap(10);

        tulipFlower.setIcon(scaledIcon6);
        tulipFlower.setHorizontalTextPosition(JLabel.RIGHT);
        tulipFlower.setVerticalTextPosition(JLabel.CENTER);
        tulipFlower.setIconTextGap(10);

    }

    public void setController (OrderController controller){
        this.orderController = controller;

        RosePrice.setText("$ " + orderController.setPrice("Rose"));
        SunflowerPrice.setText("$ " + orderController.setPrice("Sunflower"));
        LilyPrice.setText("$ " + orderController.setPrice("Lily"));
        CarnationPrice.setText("$ " + orderController.setPrice("Carnation"));
        TulipPrice.setText("$ " + orderController.setPrice("Tulip"));
        DaisyPrice.setText("$ " + orderController.setPrice("Daisy"));

        checkoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    orderController.userActions("Checkout");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        roseQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(roseCount.getText());
                if (orderController.validIncrease(c, "Rose")){
                   c++;
                   orderController.addFlower("Rose");
                   totalPrice.setText(orderController.getTotalPrice() +"");
                   roseCount.setText(c+"");
                }

            }
        });
        roseQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(roseCount.getText());
                if (c > 0){
                    c--;
                    orderController.removeFlower("Rose");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    roseCount.setText(c+"");
                }

            }
        });

        carnationQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(carnationCount.getText());
                if (orderController.validIncrease(c, "Carnation")){
                    c++;
                    orderController.addFlower("Carnation");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    carnationCount.setText(c+"");
                }
            }
        });

        carnationQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(carnationCount.getText());
                if (c > 0){
                    c--;
                    orderController.removeFlower("Carnation");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    carnationCount.setText(c+"");
                }
            }
        });

        daisyQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(daisyCount.getText());
                if (orderController.validIncrease(c, "Daisy")){
                    c++;
                    orderController.addFlower("Daisy");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    daisyCount.setText(c+"");
                }
            }
        });

        daisyQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(daisyCount.getText());
                if (c > 0){
                    c--;
                    orderController.removeFlower("Daisy");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    daisyCount.setText(c+"");
                }
            }
        });

        lilyQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(lilyCount.getText());
                if (orderController.validIncrease(c, "Lily")){
                    c++;
                    orderController.addFlower("Lily");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    lilyCount.setText(c+"");
                }

            }
        });

        lilyQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(lilyCount.getText());
                if (c > 0){
                    c--;
                    orderController.removeFlower("Lily");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    lilyCount.setText(c+"");
                }
            }
        });

        sunflowerQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(sunflowerCount.getText());
                if (orderController.validIncrease(c, "Sunflower")){
                    c++;
                    orderController.addFlower("Sunflower");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    sunflowerCount.setText(c+"");
                }

            }
        });

        sunflowerQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(sunflowerCount.getText());
                if (c > 0){
                    c--;
                    orderController.removeFlower("Sunflower");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    sunflowerCount.setText(c+"");
                }

            }
        });

        tulipQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(tulipCount.getText());
                if (orderController.validIncrease(c, "Tulip")){
                    c++;
                    orderController.addFlower("Tulip");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    tulipCount.setText(c+"");
                }

            }
        });

        tulipQuantityDecrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(tulipCount.getText());
                if (c > 0){
                    c--;
                    orderController.removeFlower("Tulip");
                    totalPrice.setText(orderController.getTotalPrice() +"");
                    tulipCount.setText(c+"");
                }
            }
        });


    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new StemPanel().StemPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.pack();
        frame.setVisible(true);


    }
}
