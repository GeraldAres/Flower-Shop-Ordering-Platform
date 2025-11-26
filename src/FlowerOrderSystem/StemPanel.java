package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class StemPanel {
    JPanel StemPanel;
    private JPanel FlowersPanel;
    private JLabel flower1;
    private JLabel flower1Increase;
    private JLabel flower1Decrease;
    private JLabel flower2Increase;
    private JLabel flower2Decrease;
    private JLabel flower4Increase;
    private JLabel flower4Decrease;
    private JLabel flower3Increase;
    private JLabel flower3Decrease;
    private JLabel flower5Increase;
    private JLabel flower5Decrease;
    private JLabel flower7Increase;
    private JLabel flower6Increase;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel flower2;
    private JLabel flower3;
    private JLabel flower4;
    private JLabel flower5;
    private JLabel flower6;

    public StemPanel() {
        // Load the image
        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/flower.jpeg");

        // Optional: scale the image to fit nicely
        Image img = image1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        flower1.setIcon(scaledIcon);
        flower1.setHorizontalTextPosition(JLabel.RIGHT);
        flower1.setVerticalTextPosition(JLabel.CENTER);
        flower1.setIconTextGap(10);

        flower2.setIcon(scaledIcon);
        flower2.setHorizontalTextPosition(JLabel.RIGHT);
        flower2.setVerticalTextPosition(JLabel.CENTER);
        flower2.setIconTextGap(10);

        flower3.setIcon(scaledIcon);
        flower3.setHorizontalTextPosition(JLabel.RIGHT);
        flower3.setVerticalTextPosition(JLabel.CENTER);
        flower3.setIconTextGap(10);

        flower4.setIcon(scaledIcon);
        flower4.setHorizontalTextPosition(JLabel.RIGHT);
        flower4.setVerticalTextPosition(JLabel.CENTER);
        flower4.setIconTextGap(10);

        flower5.setIcon(scaledIcon);
        flower5.setHorizontalTextPosition(JLabel.RIGHT);
        flower5.setVerticalTextPosition(JLabel.CENTER);
        flower5.setIconTextGap(10);

        flower6.setIcon(scaledIcon);
        flower6.setHorizontalTextPosition(JLabel.RIGHT);
        flower6.setVerticalTextPosition(JLabel.CENTER);
        flower6.setIconTextGap(10);



    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new StemPanel().StemPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);


    }
}


