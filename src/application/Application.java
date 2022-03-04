package application;

import application.controller.CarController;
import application.model.World;

public class Application {
    public static void main(String[] args) {
        // Instance of this class

        World world = new World();

        CarController cc = new CarController();

        cc.setWorld(world);

        // Start the timer
        cc.startTimer();
    }
}
