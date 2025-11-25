package src.FlowerOrderSystem;

import javax.swing.*;

public class ChckOutForm {
    private JPanel MainPanel4;
    private JPanel Panel2;
    private JPanel Panel1;
    private JTextField inputField_1;
    private JCheckBox loveYou365CheckBox;
    private JCheckBox condomCheckBox;
    private JCheckBox handwrittenCardCheckBox;
    private JCheckBox fiyeroChocCheckBox;
    private JComboBox drpDownDelivery;
    private JComboBox comboBox2;
    private JButton btnOrder;
    private JButton btnPrev;
    private JTextField addressInput;
    private JLabel h2_title;
    private JLabel h1_title;
    private JLabel addLabel;
    private JLabel NameLabel;
    private JLabel NumberLabel;
    private JLabel DateLabel;
    private JLabel detailsLabel;
    private JLabel detailsInputLabel;
    private JLabel InstructionsLabel;
    private JLabel AddLabel;
    private JLabel add_1;
    private JLabel add_2;
    private JLabel add_3;
    private JLabel add_4;
    private JLabel DeliveryLabel;
    private JLabel TotalLabel;
    private JLabel PaymentLabel;
    private JLabel LabelTotal;
    private JLabel DaddressLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Check Out form");
        frame.setContentPane(new ChckOutForm().MainPanel4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
