package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class FlowerCat_Pnl1 {

    private JPanel TestAvailableFlowers;
    private JPanel holder;
    private JPanel north;
    private JPanel Body;
    private JPanel rightImg_pnl;
    private JPanel leftimg_pnl;
    private JPanel centerField_pnl;
    private JLabel placeholder1;
    private JLabel desc2;
    private JButton nextBtn;
    private JLabel desc3;
    private JLabel desc1;
    private JLabel Title1;
    private JLabel placeholder2;
    private JLabel decor2;
    private JLabel decor1;
    private JLabel TitlePanel;
    private JButton prevBtn;

    public FlowerCat_Pnl1(){

        ImageIcon img = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Tulip.png");
        Image scaled = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        placeholder1.setIcon(new ImageIcon(scaled));

        ImageIcon img1 = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Daisy.png");
        Image scaled1 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        placeholder2.setIcon(new ImageIcon(scaled1));

        /// IMAGE HOLDER
        ImageIcon image4 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/flowerBorder.png");
        Image img4 = image4.getImage().getScaledInstance(200, 900, Image.SCALE_SMOOTH);
        decor1.setIcon(new ImageIcon(img4));

        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/FlippedFlowerBorder.png");
        Image img5 = image5.getImage().getScaledInstance(200, 900, Image.SCALE_SMOOTH);
        decor2.setIcon(new ImageIcon(img5)); // LEFT
        /// IMAGE SIDE HOLDER

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img8 =  image1.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img8);
        prevBtn.setIcon(prev);
        prevBtn.setText("");
        prevBtn.setOpaque(false);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setBorderPainted(false);
        prevBtn.setFocusPainted(false);
        prevBtn.setText("");

        ImageIcon image6 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/nextBtn.png");
        Image img7 =  image6.getImage().getScaledInstance(100, 35, Image.SCALE_SMOOTH);
        ImageIcon btnNext = new ImageIcon(img7);
        nextBtn.setIcon(btnNext);
        nextBtn.setText("");
        nextBtn.setOpaque(false);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setBorderPainted(false);
        nextBtn.setFocusPainted(false);
        nextBtn.setText("");

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flower Catalogue");
        FlowerCat_Pnl1 panel = new FlowerCat_Pnl1();
        frame.setContentPane(panel.TestAvailableFlowers);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
