package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

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
    private JLabel roseFlower;
    private JLabel lilyFlower;
    private JLabel sunflowerFlower;
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
    private JLabel carnationFlower;
    private JLabel tulipFlower;
    private JLabel daisyFlower;

    private Order order = new Order("Stem");

    private ImageIcon addMarginToImage(Image img, int margin) {
        int w = img.getWidth(null) + margin * 2;
        int h = img.getHeight(null) + margin * 2;

        BufferedImage padded = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = padded.createGraphics();

        g.setComposite(AlphaComposite.SrcOver);

        // optional: background color of margin
        // g.setColor(Color.WHITE);
        // g.fillRect(0, 0, w, h);

        // draw image centered inside the margin
        g.drawImage(img, margin, margin, null);
        g.dispose();

        return new ImageIcon(padded);
    }


    public StemPanel() {
        // Load the image
        ImageIcon roseImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Rose.png");
        ImageIcon carnationImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Carnation.png");
        ImageIcon daisyImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Daisy.png");
        ImageIcon lilyImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Lily.png");
        ImageIcon sunflowerImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Sunflower.png");
        ImageIcon tulipImage = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Tulip.png");

        ImageIcon prevBtnImage = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
//        ImageIcon checkoutBtnImage = new ImageIcon("");

        Image img0 = prevBtnImage.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon0 = new ImageIcon(img0);

        // Optional: scale the image to fit nicely
        Image img1 = roseImage.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(img1);

        Image img2 = carnationImage.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(img2);

        Image img3 = daisyImage.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(img3);

        Image img4 = lilyImage.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(img4);

        Image img5 = sunflowerImage.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(img5);

        Image img6 = tulipImage.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(img6);


        prevBtn.setIcon(scaledIcon0);
        prevBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        prevBtn.setVerticalTextPosition(SwingConstants.CENTER);
        prevBtn.setIconTextGap(0);
        prevBtn.setBorderPainted(false);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);
        prevBtn.setOpaque(false);


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
        daisyFlower.setVerticalTextPosition(JLabel.CENTER);
        daisyFlower.setIconTextGap(10);

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

        Stem rose = new Rose("red");
        Stem carnation = new Carnation("red");
        Stem daisy = new Daisy("red");
        Stem lily = new Lily("red");
        Stem sunflower = new Sunflower("red");
        Stem tulip = new Tulip("red");

        roseQuantityIncrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = Integer.parseInt(roseCount.getText());

                if(c < Integer.parseInt(roseStock.getText())){
                    c++;

                    order.addFlower(rose);

                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");

                    roseCount.setText(c + "");
                }



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
                int c = Integer.parseInt(carnationCount.getText());

                if(c < Integer.parseInt(carnationStock.getText())){
                    c++;

                    order.addFlower(carnation);
                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");

                    carnationCount.setText(c + "");
                }


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
                int c = Integer.parseInt(daisyCount.getText());

                if(c < Integer.parseInt(daisyStock.getText())){
                    c++;

                    order.addFlower(daisy);
                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");

                    daisyCount.setText(c + "");
                }


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
                int c = Integer.parseInt(lilyCount.getText());

                if(c < Integer.parseInt(lilyStock.getText())){
                    c++;

                    order.addFlower(lily);
                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");

                    lilyCount.setText(c + "");
                }


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
                int c = Integer.parseInt(sunflowerCount.getText());

                if(c < Integer.parseInt(sunflowerStock.getText())){
                    c++;

                    order.addFlower(sunflower);
                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");

                    sunflowerCount.setText(c + "");
                }

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
                int c = Integer.parseInt(tulipCount.getText());

                if(c < Integer.parseInt(tulipStock.getText())){
                    c++;

                    order.addFlower(tulip);
                    order.setPrice();

                    totalPrice.setText(order.getOrderPrice() + "");

                    tulipCount.setText(c + "");
                }

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
        frame.setSize(1080, 1440);
        frame.pack();
        frame.setVisible(true);
    }
}
