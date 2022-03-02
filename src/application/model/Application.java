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

        World world = new World();


        CarController cc = new CarController();

        List<Drawable> drawables = new ArrayList<>();

        List<Vehicle> vehicles = List.of(
                new Volvo240(0, 0, AbstractMovable.Direction.EAST),
                new Saab95(0, 100, AbstractMovable.Direction.EAST) ,
                new Scania(0, 200, AbstractMovable.Direction.EAST)
        );

        for (Vehicle v : vehicles) {
            Drawable d = new Drawable(v.getModelName(), new Point((int)(Math.round(v.getX())), (int)(Math.round(v.getY()))));
            drawables.add(d);
        }

        world.setVehicles(vehicles);
        cc.setWorld(world);

        // Start a new application.application.view and send a reference of self
        cc.setFrame(new CarView("CarSim 1.0", cc, drawables));

        world.setObservers(List.of(cc.getFrame().drawPanel));

        // Start the timer
        cc.startTimer();
    }
}
