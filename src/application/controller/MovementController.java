package application.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovementController implements ActionListener {

    VehicleModel world;

    public MovementController(VehicleModel world) {
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        world.moveVehicles();

    }
}
