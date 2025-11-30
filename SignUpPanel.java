import javax.swing.*;

public class SignUpPanel {
    JPanel SignUpPnl;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel RightTitle1;
    private JPanel Left;
    private JTextField username;
    private JTextField passwordField;
    private JButton btnCreateAccount;
    private JLabel InvalidUsername;
    private JLabel invalidPassword;
    private JButton prevButton;
    private JPanel Holder;
    private JTextField confirmpassword;
    private JLabel confirmPassField;
    private JTextField usernameField;
    private JLabel usernameText;
    private JTextField contactNumberField;
    private JLabel contactNumber;
    private JTextField EmailField;
    private JLabel email;
    private JLabel UsrName;
    private JLabel password;
    private JLabel Title3;
    private JLabel Title2;
    private JLabel Title1;
    private JLabel groupTitle4;
    private JLabel RightTitle2;
    private JLabel SubTitle1;
    private JLabel SubTitle2;
    private JLabel GroupTitle1;
    private JLabel SubTitle3;
    private JLabel loginTextBtn;
    private JPanel Log;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SignUpPanel().SignUpPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}

