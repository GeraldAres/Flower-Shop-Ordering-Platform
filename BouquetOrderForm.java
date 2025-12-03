import javax.swing.*;

public class BouquetOrderForm {


    private JPanel Bouquet;
    private JPanel Holder;
    private JPanel SouthPanel;
    private JPanel NorthPanel;
    private JLabel subTitle1;
    private JLabel brandTitle1;
    private JButton btnBuy;
    private JLabel placeholder1;
    private JLabel RoseBouquet;
    private JLabel StockLabel;
    private JLabel getColor;
    private JLabel getPrice;
    private JLabel getStocks;
    private JButton prevButton;

    static void main() {
        JFrame frame = new JFrame("Bouquet Order System");
        frame.setContentPane(new BouquetOrderForm().Bouquet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
