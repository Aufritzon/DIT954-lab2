package application.controller;

import application.model.*;
import application.view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the application.application.model state and the updating the application.application.view.
 */

public class CarController implements ActionListener {
    // member fields:


    // A list of cars, modify if needed
    World world;

    CarView frame;

    public CarController(World world, CarView frame) {
        this.world = world;
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() != null) {
            switch (e.getActionCommand()) {
                case "Gas" -> world.gasVehicles(frame.getGasAmount());
                case "Brake" -> world.brakeVehicles(frame.getGasAmount());
                case "TurboOn" -> world.turnOnTurbos();
                case "TurboOff" -> world.turnOffTurbos();
                case "RaiseBed" -> world.raiseBeds();
                case "LowerBed" -> world.lowerBeds();
                case "Start" -> world.startVehicles();
                case "Stop" -> world.stopVehicles();
            }
        } else {
            world.moveVehicles();
            frame.repaintDrawPanel();
        }
    }
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * application.application.view to update its images. Change this method to your needs.
    * */

}
