import javax.swing.*;

public class SignUpPanel {
    JPanel SignUpPnl;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JTextField username;
    private JTextField password;
    private JButton createAccountButton;
    private JLabel InvalidUsername;
    private JLabel invalidPassword;
    private JButton prevButton;
    private JPanel Holder;
    private JTextField confirmpassword;
    private JLabel ConfirmPassField;
    private JTextField usernameField;
    private JLabel usernameText;
    private JTextField ContactNoField;
    private JLabel ContactNo;
    private JTextField EmailField;
    private JLabel email;
    private JPanel Log;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SignUpPanel().SignUpPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}

