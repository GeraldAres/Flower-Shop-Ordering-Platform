package src.FlowerOrderSystem;
import src.FlowerOrderSystem.InvalidInputException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderPanel {
    JPanel OrderPanel;
    private JPanel InputArea;
    private JLabel BrandName;
    private JTextField userContactNumber;
    private JTextField userAddress;
    private JTextField userName;
    private JPanel ServicesBtn;
    private JButton stemButton;
    private JButton bouquetButton;
    private JButton btnPrevious;
    private JLabel invalidNameLbl;
    private JLabel invalidAddressLbl;
    private JLabel invalidContactLbl;
    private src.FlowerOrderSystem.NewForm newForm;

    public OrderPanel(JPanel MainPanel, CardLayout cardLayout) {
        final JPanel parentPanel = MainPanel;
        final CardLayout layout = cardLayout;

        newForm = new NewForm(parentPanel, layout);
        stemButton.setEnabled(false);
        bouquetButton.setEnabled(false);
        invalidNameLbl.setVisible(false);
        invalidAddressLbl.setVisible(false);
        invalidContactLbl.setVisible(false);

        userName.addActionListener(e -> validateInputs());
        userAddress.addActionListener(e -> validateInputs());
        userContactNumber.addActionListener(e -> validateInputs());

        stemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newForm.createOrder("Stem");
            }
        });

        bouquetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newForm.createOrder("Bouquet");
            }
        });

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(parentPanel, "FirstPage");
            }
        });
    }

    private void validateInputs() {

        // Reset visibility
        invalidNameLbl.setVisible(false);
        invalidAddressLbl.setVisible(false);
        invalidContactLbl.setVisible(false);

        String name = userName.getText().trim();
        String address = userAddress.getText().trim();
        String contact = userContactNumber.getText().trim();

        try {
            newForm.createUser(name, address, contact);
            stemButton.setEnabled(true);
            bouquetButton.setEnabled(true);

        } catch (InvalidInputException e) {

            // ANY invalid → disable buttons
            stemButton.setEnabled(false);
            bouquetButton.setEnabled(false);

            // Show the correct error label based on exception message
            switch (e.getMessage()) {

                case "Invalid name":
                    invalidNameLbl.setVisible(true);
                    break;

                case "Invalid address":
                    invalidAddressLbl.setVisible(true);
                    break;

                case "Invalid contact number":
                    invalidContactLbl.setVisible(true);
                    break;
            }
        }
    }
}
