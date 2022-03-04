package application.controller;

import application.model.*;
import application.view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the application.application.model state and the updating the application.application.view.
 */

public class CarController implements ICarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame =  new CarView("CarSim 1.0", this);
    // A list of cars, modify if needed
    World world;

    //methods:

    @Override
    public void startTimer() {
        timer.start();
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
        world.addObserver(frame);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * application.application.view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.moveVehicles();
            frame.repaintDrawPanel();
        }
    }

    public void gas(int amount) {
        world.gasVehicles(amount);
    }

    public void brake(int amount) {
        world.brakeVehicles(amount);
    }

    public void startEngine() {
        world.startVehicles();
    }

    public void stopEngine() {
        world.stopVehicles();
    }

    public void lowerBed() {
        world.lowerBeds();
    }

    public void raiseBed() {
        world.raiseBeds();
    }

    public void turboOn() {
        world.turnOnTurbos();
    }

    public void turboOff()  {
        world.turnOffTurbos();
    }

}
