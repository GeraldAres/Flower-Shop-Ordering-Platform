package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.MainController;
import src.FlowerOrderSystem.Controllers.UserSetup;

import javax.swing.*;
import java.awt.*;

public class Main {


    public static void main(String[] args) throws InvalidInputException {
        UserSetup setup = new UserSetup(null);

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/HirayaCebu.png");
        Image img = image1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        MainPanel  mainPanelClass = new MainPanel();
        JPanel mainPanel = mainPanelClass.MainPanel;

        JFrame frame = new JFrame("Hiraya Cebu");
        frame.setIconImage(scaledIcon.getImage());
        frame.setContentPane(new MainPanel().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
        MainController controller = new MainController(mainPanel , setup);



    }
}
