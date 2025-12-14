package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class FlowerCat_Pnl3 {
    private JPanel FlwrCat_Pnl3;
    private JPanel holder;
    private JPanel north;
    private JPanel Body;
    private JPanel leftimg_pnl;
    private JLabel decor1;
    private JPanel rightImg_pnl;
    private JLabel decor2;
    private JPanel centerField_pnl;
    private JLabel desc2;
    private JButton nextBtn;
    private JLabel desc3;
    private JLabel desc1;
    private JLabel Title1;
    private JLabel placeholder1;
    private JLabel placeholder2;
    private JLabel TitlePanel;
    private JLabel Header;
    private JButton prevbtn;


    FlowerCat_Pnl3(){

        ImageIcon img = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Carnation.png");
        Image scaled = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        placeholder1.setIcon(new ImageIcon(scaled));

        ImageIcon img1 = new ImageIcon("src/FlowerOrderSystem/Assets/Flower illustrations/Lily.png");
        Image scaled1 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        placeholder2.setIcon(new ImageIcon(scaled1));

        ImageIcon image4 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/flowerBorder.png");
        decor1.setIcon(new ImageIcon(
                image4.getImage().getScaledInstance(200, 900, Image.SCALE_SMOOTH)
        ));

        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/FlippedFlowerBorder.png");
        decor2.setIcon(new ImageIcon(
                image5.getImage().getScaledInstance(200, 900, Image.SCALE_SMOOTH)
        ));

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img8 =  image1.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img8);
        prevbtn.setIcon(prev);
        prevbtn.setText("");
        prevbtn.setOpaque(false);
        prevbtn.setContentAreaFilled(false);
        prevbtn.setBorderPainted(false);
        prevbtn.setFocusPainted(false);
        prevbtn.setText("");

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
        FlowerCat_Pnl3 panel = new FlowerCat_Pnl3();
        frame.setContentPane(panel.holder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
