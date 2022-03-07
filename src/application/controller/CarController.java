package application.controller;

import application.model.world.World;
import application.view.CarView;
import application.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController {

    WorldModel world;
    CarView frame;

    public CarController(World world, CarView frame) {
        this.world = world;
        this.frame = frame;
    }

    public void initController(){
        frame.addGasListener(e -> world.gasVehicles(frame.getGasAmount()));
        frame.addBrakeListener(e -> world.brakeVehicles(frame.getGasAmount()));
        frame.addLiftBedListener(e -> world.raiseBeds());
        frame.addLowerBedListener(e -> world.lowerBeds());
        frame.addTurboOnListener(e -> world.turnOnTurbos());
        frame.addTurboOffListener(e -> world.turnOffTurbos());
        frame.addStartListener(e -> world.startVehicles());
        frame.addStopListener(e -> world.stopVehicles());
    }

    public void startTimer(int delay) {
        new Timer(delay,  new TimerListener()).start();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            world.moveVehicles();
            frame.updateView(world);
            frame.repaintView();
        }

    }

}
