package application.model.vehicles;

import application.model.VehicleModel;
import javax.swing.*;
import java.awt.*;

public class AddVehicleController {
    private final VehicleModel world;
    private JPanel addRemovePanel;

    public AddVehicleController(VehicleModel world) {
        this.world = world;
        initComponents();
    }

    public JPanel getAddRemovePanel() {
        return addRemovePanel;
    }

    private void initComponents() {
        addRemovePanel = new JPanel();
        addRemovePanel.setPreferredSize(new Dimension(200,240));
        JButton addButton = new JButton("Add vehicle");
        JButton removeButton = new JButton("Remove vehicle");
        addButton.addActionListener(e -> addVehiclePerformed());
        removeButton.addActionListener(e -> removeVehiclePerformed());

        addRemovePanel.setLayout(new GridLayout(2,1));
        addRemovePanel.add(addButton);
        addRemovePanel.add(removeButton);
    }

    public void addVehiclePerformed() {
        if (world.getVehicles().getSize() < 10) {
            world.getVehicles().add();
        }
    }

    public void removeVehiclePerformed() {
        world.getVehicles().remove();
    }
}
