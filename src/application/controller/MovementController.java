package application.controller;

import application.model.VehicleModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovementController implements ActionListener {

    private final VehicleModel world;

    public MovementController(VehicleModel world) {
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        world.moveVehicles();

    }
}
