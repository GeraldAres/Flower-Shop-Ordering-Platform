package src.FlowerOrderSystem;

import javax.swing.*;

public class SampleStemFullScreenPanel {
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
    private JPanel SampleStemPnlFllScrn;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SampleStemFullScreenPanel().SampleStemPnlFllScrn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
