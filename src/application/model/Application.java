package application.model;

import application.view.CarController;
import application.view.CarView;
import application.view.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Instance of this class



        CarController cc = new CarController();


        // Start a new application.application.view and send a reference of self
        cc.setFrame(new CarView("CarSim 1.0", cc));

        World world = new World(cc.getFrame().drawPanel);


        List<Drawable> drawables = new ArrayList<>();

        cc.setWorld(world);



        // Start the timer
        cc.startTimer();
    }
}
