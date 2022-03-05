package application;

import application.controller.CarController;
import application.model.World;
import application.view.CarView;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        // Instance of this class


        // The delay (ms) corresponds to 20 updates a sec (hz)

        // The timer is started with an listener (see below) that executes the statements
        // each step between delays.
        World world = new World();

        CarView frame = new CarView("CarSim 1.0");

        world.addObserver(frame);
        CarController cc = new CarController(world, frame);


        frame.registerListeners(cc);

        int delay = 50;

        Timer timer = new Timer(delay, cc);

        timer.start();



    }
}
