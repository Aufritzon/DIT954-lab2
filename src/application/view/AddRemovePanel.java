package application.view;

import javax.swing.*;
import java.awt.*;

public class AddRemovePanel extends JPanel {
    JButton addVehicleButton = new JButton("Add vehicle");
    JButton removeVehicleButton = new JButton("Remove vehicle");

    public AddRemovePanel(int width, int height) {
        this.setPreferredSize(new Dimension(width,height));
        this.setLayout(new GridLayout(2,2));
        initAddButton();
        initRemoveButton();
    }
    private void initAddButton() {
        addVehicleButton.setBackground(Color.magenta);
        addVehicleButton.setForeground(Color.green);
        this.add(addVehicleButton);
    }
    private void initRemoveButton() {
        removeVehicleButton.setBackground(Color.magenta);
        removeVehicleButton.setForeground(Color.green);
        this.add(removeVehicleButton);

    }


}
