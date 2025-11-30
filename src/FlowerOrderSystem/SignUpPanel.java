package src.FlowerOrderSystem;

import javax.swing.*;

public class SignUpPanel {
    private JPanel MainPanel_SignUP;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField CheckerPass;
    private JPasswordField CheckerPass2;
    private JButton btnsignUp;
    private JButton btnprev;
    private JLabel Headline2;
    private JLabel nameField;
    private JLabel enailField;
    private JLabel numberField;
    private JLabel usernameField;
    private JLabel passField;
    private JLabel conPassField;
    private JLabel Title;
    private JLabel title1;
    private JLabel subdescript2;
    private JLabel subdescrip3;
    private JLabel subTitle2;
    private JLabel groupTitle;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign up form");
        frame.setContentPane(new SignUpPanel().MainPanel_SignUP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
