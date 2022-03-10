package application.view;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    public ControlPanel(int width, int height) {

        this.setLayout(new GridLayout(2, 4));

        this.add(gasButton, 0);
        this.add(turboOnButton, 1);
        this.add(liftBedButton, 2);
        this.add(brakeButton, 3);
        this.add(turboOffButton, 4);
        this.add(lowerBedButton, 5);

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.CYAN);
    }
}
