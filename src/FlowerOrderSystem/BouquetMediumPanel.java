package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class BouquetMediumPanel {

    JPanel Bouquet;
    private JPanel Holder;
    private JPanel SouthPanel;
    private JPanel NorthPanel;
    private JLabel subTitle1;
    private JLabel brandTitle1;
    private JButton btnBuy;
    private JLabel placeholder1;
    private JLabel RoseBouquet;
    private JLabel StockLabel;
    private JLabel getColor;
    private JLabel getPrice;
    private JLabel getStocks;
    private JButton prevButton;
    private JButton btnCheckOut;
    private JLabel placeholder3;
    private JLabel placeholder4;
    private JLabel placeholder6;
    private JLabel placeholder5;
    private JLabel placeholder2;

    public static void main(String[] args) {

        // Create ONE SINGLE instance
        BouquetMediumPanel form = new BouquetMediumPanel();

        // Load image into THAT SAME instance
        ImageIcon img = new ImageIcon("src/assets/testFlower.png");
        Image scaled = img.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        form.placeholder1.setIcon(new ImageIcon(scaled));

        ImageIcon img2 = new ImageIcon("src/assets/testFlower.png");
        Image scaled2 = img.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        form.placeholder2.setIcon(new ImageIcon(scaled2));

        ImageIcon img3 = new ImageIcon("src/assets/testFlower.png");
        Image scaled3 = img.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        form.placeholder3.setIcon(new ImageIcon(scaled3));

        ImageIcon img4 = new ImageIcon("src/assets/testFlower.png");
        Image scaled4 = img.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        form.placeholder4.setIcon(new ImageIcon(scaled4));

        ImageIcon img5 = new ImageIcon("src/assets/testFlower.png");
        Image scaled5 = img.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        form.placeholder5.setIcon(new ImageIcon(scaled5));

        ImageIcon img6 = new ImageIcon("src/assets/testFlower.png");
        Image scaled6 = img.getImage().getScaledInstance(75, 70, Image.SCALE_SMOOTH);
        form.placeholder6.setIcon(new ImageIcon(scaled6));

        // Show THAT SAME instance in the frame
        JFrame frame = new JFrame("Bouquet Order System");
        frame.setContentPane(form.Bouquet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
