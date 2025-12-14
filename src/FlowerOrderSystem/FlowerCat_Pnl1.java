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
    private JButton nextButton;
    private JLabel desc3;
    private JLabel desc1;
    private JLabel Title1;
    private JLabel placeholder2;
    private JLabel decor2;
    private JLabel decor1;
    private JLabel TitlePanel;

    public static void main(String[] args) {

        FlowerCat_Pnl1 form = new FlowerCat_Pnl1();

        ImageIcon img = new ImageIcon("src/assets/testFlower.png");
        Image scaled = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        form.placeholder1.setIcon(new ImageIcon(scaled));

        ImageIcon img1 = new ImageIcon("src/assets/testFlower.png");
        Image scaled1 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        form.placeholder2.setIcon(new ImageIcon(scaled));

        JFrame frame = new JFrame("Order System");
        frame.setContentPane(form.TestAvailableFlowers); // USE SAME INSTANCE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
