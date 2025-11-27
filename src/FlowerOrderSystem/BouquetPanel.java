package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouquetPanel {
    JPanel BouquetPanel;
    private JPanel FieldPanel;
    private JPanel ProductPanel;
    private JComboBox BoxSize;
    private JComboBox BoxColor;
    private JLabel labelSize;
    private JLabel labelColor;
    private JButton buyRoseBtn;
    private JButton buyTulipsBtn;
    private JButton buyLiliesBtn;
    private JButton buySunflowerBtn;
    private JPanel CustomPanel;
    private JButton btnBuy;
    private JButton btnPrev;
    private JLabel img2;
    private JLabel img3;
    private JLabel img4;
    private JLabel img1;
    private JLabel headlineLabel;
    private JLabel labelPrice;
    private JLabel prc4;
    private JLabel prc1;
    private JLabel prc2;
    private JLabel prc3;
    private JLabel color4;
    private JLabel color3;
    private JLabel color2;
    private JLabel color1;
    private JLabel product4;
    private JLabel product2;
    private JLabel product3;
    private JLabel product1;

    private PreMade premade;
    int size = 1;

    public BouquetPanel(){

        //small = 1, etc.
        BoxSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = BoxSize.getSelectedIndex() + 1;
            }
        });

        buyRoseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                premade = new PreMade(new Rose("red"), size);
            }
        });

        buyLiliesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                premade = new PreMade(new Lily("red"), size);
            }
        });

        buyTulipsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                premade = new PreMade(new Tulip("red"), size);
            }
        });

        buySunflowerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                premade = new PreMade(new Sunflower("red"), size);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Boquet System");
        frame.setContentPane(new BouquetPanel().BouquetPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.pack();
        frame.setVisible(true);
    }
}
