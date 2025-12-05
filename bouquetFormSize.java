import javax.swing.*;

public class bouquetFormSize {
    private JPanel Bouquet;
    private JPanel Holder;
    private JPanel SouthPanel;
    private JLabel SizeLabel;
    private JComboBox SizeField;
    private JLabel wrpColorLabel;
    private JComboBox wrpColorField;
    private JButton btnNext;
    private JButton btnPrev;
    private JPanel NorthPanel;
    private JLabel brandTitle1;
    private JLabel subTitle1;

    static void main() {
        JFrame frame = new JFrame("Bouquet Order System");
        frame.setContentPane(new bouquetFormSize().Bouquet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
