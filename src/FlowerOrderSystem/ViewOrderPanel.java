package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewOrderPanel {

    private JPanel ViewOrderPnl;
    private JPanel Header;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel Body;
    private JPanel North;
    private JPanel West;
    private JPanel South;
    private JPanel East;
    private JPanel Order;
    private JScrollPane Scrikk;
    private JPanel Status1;
    private JPanel Date1;
    private JPanel One;
    private JPanel View1;
    private JPanel Two;
    private JLabel LeftImg;
    private JLabel RightImg;
    private JPanel LeftSouth;
    private JPanel RightSouth;
    private JButton prevButton;

    public ViewOrderPanel(JPanel MainPanel, CardLayout cardLayout){
        ImageIcon img = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Doggos.png");
        Image imgg =  img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon set = new ImageIcon(imgg);
        LeftImg.setIcon(set);
        LeftImg.setText("");
        RightImg.setIcon(set);
        RightImg.setText("");

        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img5=  image5.getImage().getScaledInstance(18, 10, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img5);
        prevButton.setIcon(prev);
        prevButton.setText("");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainPanel, "FirstPage");
            }
    });
    }

    public ViewOrderPanel() {

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new ViewOrderPanel().ViewOrderPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
