package application.view;

import application.model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the application.application.model state and the updating the application.application.view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    World world;

    //methods:


    public CarView getFrame() {
        return frame;
    }

    public void setWorld(World world) {
        this.world = world;
    }



    public void setFrame(CarView frame) {
        this.frame = frame;
    }

    public void startTimer() {
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * application.application.view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.moveVehicles();
            frame.drawPanel.repaint();
        }

        private int toInt (double d) {
           return (int) Math.round(d);
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