package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.OrderController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouquetOrderForm {

    JPanel Bouquet;
    private JPanel StemPanel;
    private JPanel Container;
    private JPanel Header;
    private JPanel Center;
    private JPanel left;
    private JPanel leftside_left;
    private JLabel roseFlower;
    private JLabel lilyFlower;
    private JLabel sunflowerFlower;
    private JPanel rightside_left;
    private JLabel roseQuantityIncrease;
    private JLabel roseQuantityDecrease;
    private JLabel lilyQuantityIncrease;
    private JLabel lilyQuantityDecrease;
    private JLabel sunflowerQuantityIncrease;
    private JLabel sunflowerQuantityDecrease;
    private JLabel roseCount;
    private JLabel lilyCount;
    private JLabel sunflowerCount;
    private JPanel center_left;
    private JLabel RosePrice;
    private JLabel roseStock;
    private JLabel roseColor;
    private JLabel LilyPrice;
    private JLabel lilyStock;
    private JLabel lilyColor;
    private JLabel SunflowerPrice;
    private JLabel sunflowerStock;
    private JLabel sunflowerColor;
    private JPanel right;
    private JPanel leftside_right;
    private JLabel tulipFlower;
    private JLabel carnationFlower;
    private JLabel daisyFlower;
    private JPanel rightside_right;
    private JLabel tulipQuantityIncrease;
    private JLabel carnationQuantityIncrease;
    private JLabel daisyQuantityIncrease;
    private JLabel tulipCount;
    private JLabel tulipQuantityDecrease;
    private JLabel carnationCount;
    private JLabel carnationQuantityDecrease;
    private JLabel daisyCount;
    private JLabel daisyQuantityDecrease;
    private JPanel center_right;
    private JLabel TulipPrice;
    private JLabel tulipStock;
    private JLabel tulipsColor;
    private JLabel CarnationPrice;
    private JLabel carnationStock;
    private JLabel carnationsColor;
    private JLabel DaisyPrice;
    private JLabel daisyStock;
    private JLabel daisyColor;
    private JButton prevBtn;
    private JButton checkoutBtn;
    private JLabel totalPrice;
    private JLabel subTitle1;

    private OrderController orderController;
    private int bouquetSize;
    private Inventory inventory = new Inventory();



    public void setController(OrderController orderController, int size){
        this.orderController = orderController;
        bouquetSize = size;


        switch (size){
            case 0:

                roseStock.setText(inventory.getStockCount("rose")  / 3+ "");
                carnationStock.setText(inventory.getStockCount("carnation")  / 3+ "");
                sunflowerStock.setText(inventory.getStockCount("sunflower")  / 3+ "");
                daisyStock.setText(inventory.getStockCount("daisy")  / 3+ "");
                lilyStock.setText(inventory.getStockCount("lily")  / 3+ "");
                tulipStock.setText(inventory.getStockCount("tulip")  / 3+ "");


                // Load image into THAT SAME instance
                subTitle1.setText("Small Bouquet Order Form ");
                ImageIcon smallRose = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/3 Rose Bouquet.png");
                ImageIcon smallLily = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/3 Lily Bouquet.png");
                ImageIcon smallSunflower = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/3 Sunflower Bouquet.png");
                ImageIcon smallCarnation = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/3 Carnation Bouquet.png");
                ImageIcon smallTulip = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/3 Carnation Bouquet.png");
                ImageIcon smallDaisy = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/3 Daisy Bouquet.png");

                Image scaleds = smallRose.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                roseFlower.setIcon(new ImageIcon(scaleds));


                Image scaleds2 = smallLily.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                lilyFlower.setIcon(new ImageIcon(scaleds2));

                Image scaleds3 = smallSunflower.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                sunflowerFlower.setIcon(new ImageIcon(scaleds3));

                Image scaleds4 = smallCarnation.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                carnationFlower.setIcon(new ImageIcon(scaleds4));

                Image scaleds5 = smallTulip.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                tulipFlower.setIcon(new ImageIcon(scaleds5));

                Image scaleds6 = smallDaisy.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                daisyFlower.setIcon(new ImageIcon(scaleds6));

                break;
            case 1:
                subTitle1.setText("Medium Bouquet Order Form ");

                roseStock.setText(inventory.getStockCount("rose")  / 6+ "");
                carnationStock.setText(inventory.getStockCount("carnation")  / 6+ "");
                sunflowerStock.setText(inventory.getStockCount("sunflower")  / 6+ "");
                daisyStock.setText(inventory.getStockCount("daisy")  / 6+ "");
                lilyStock.setText(inventory.getStockCount("lily")  / 6+ "");
                tulipStock.setText(inventory.getStockCount("tulip")  / 6+ "");

                ImageIcon mediumRose = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/6 Rose Bouquet.png");
                ImageIcon mediumLily = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/6 Lily Bouquet.png");
                ImageIcon mediumSunflower = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/6 Sunflower Bouquet.png");
                ImageIcon mediumCarnation = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/6 Carnation Bouquet.png");
                ImageIcon mediumTulip = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/6 Carnation Bouquet.png");
                ImageIcon mediumDaisy = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/6 Daisy Bouquet.png");

                Image scaledm = mediumRose.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                roseFlower.setIcon(new ImageIcon(scaledm));

                Image scaledm2 = mediumLily.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                lilyFlower.setIcon(new ImageIcon(scaledm2));

                Image scaledm3 = mediumSunflower.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                sunflowerFlower.setIcon(new ImageIcon(scaledm3));

                Image scaledm4 = mediumCarnation.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                carnationFlower.setIcon(new ImageIcon(scaledm4));

                Image scaledm5 = mediumTulip.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                tulipFlower.setIcon(new ImageIcon(scaledm5));

                Image scaledm6 = mediumDaisy.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                daisyFlower.setIcon(new ImageIcon(scaledm6));

                break;
            case 2:
                subTitle1.setText("Large Bouquet Order Form ");

                roseStock.setText(inventory.getStockCount("rose")  / 12+ "");
                carnationStock.setText(inventory.getStockCount("carnation")  / 12+ "");
                sunflowerStock.setText(inventory.getStockCount("sunflower")  / 12+ "");
                daisyStock.setText(inventory.getStockCount("daisy")  / 12+ "");
                lilyStock.setText(inventory.getStockCount("lily")  / 12+ "");
                tulipStock.setText(inventory.getStockCount("tulip")  / 12+ "");

                ImageIcon largeRose = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/12 Rose Bouquet.png");
                ImageIcon largeLily = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/12 Lily Bouquet.png");
                ImageIcon largeSunflower = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/12 Sunflower Bouquet.png");
                ImageIcon largeCarnation = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/12 Carnation Bouquet.png");
                ImageIcon largeTulip = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/12 Carnation Bouquet.png");
                ImageIcon largeDaisy = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Bouquets/12 Daisy Bouquet.png");

                Image scaledl = largeRose.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                roseFlower.setIcon(new ImageIcon(scaledl));

                Image scaledl2 = largeLily.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                lilyFlower.setIcon(new ImageIcon(scaledl2));

                Image scaledl3 = largeSunflower.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                sunflowerFlower.setIcon(new ImageIcon(scaledl3));

                Image scaledl4 = largeCarnation.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                carnationFlower.setIcon(new ImageIcon(scaledl4));

                Image scaledl5 = largeTulip.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                tulipFlower.setIcon(new ImageIcon(scaledl5));

                Image scaledl6 = largeDaisy.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                daisyFlower.setIcon(new ImageIcon(scaledl6));

                break;

        }

        prevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    orderController.userActions("SmallBack");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {

        // Create ONE SINGLE instance
        BouquetOrderForm form = new BouquetOrderForm();


        // Show THAT SAME instance in the frame
        JFrame frame = new JFrame("Bouquet Order System");
        frame.setContentPane(form.Bouquet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
