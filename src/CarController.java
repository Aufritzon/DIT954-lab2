import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
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
    List<Vehicle> cars = new ArrayList<>();

    Assets assets = new Assets();

    Map<Vehicle,BufferedImage> vehicleImageMap = new HashMap<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        List<Drawable> drawables = new ArrayList<>();


        List<Vehicle> vehicles = List.of(new Volvo240(50, 50, AbstractMovable.Direction.EAST),
                                         new Saab95(100, 100, AbstractMovable.Direction.NORTH),
                                         new Scania(300, 300, AbstractMovable.Direction.SOUTH),
                                         new Volvo240(400, 400, AbstractMovable.Direction.WEST));

        for (Vehicle v : vehicles) {
            Drawable d = new Drawable(v.getModelName(), (int)(Math.round(v.getX())), (int)(Math.round(v.getY())));
            drawables.add(d);
        }

        cc.cars.addAll(vehicles);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, drawables);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Vehicle v;
            Drawable d;
            for (int i = 0 ; i < cars.size(); i++) {
                v = cars.get(i);
                d = frame.drawPanel.getDrawables().get(i);

                v.move();

                int x = (int) Math.round(v.getX());
                int y = (int) Math.round(v.getY());

                if(frame.drawPanel.isInsideDrawPanel(d, x, y)) {
                    frame.drawPanel.moveit(d, x, y);
                } else {
                    v.setX(frame.drawPanel.getDrawablePoint(d).x);
                    v.setY(frame.drawPanel.getDrawablePoint(d).y);
                    invertDirection(v);
                }

                frame.drawPanel.repaint();
            }



        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void invertDirection(Vehicle vehicle) {
        vehicle.stopEngine();
        vehicle.turnRight();
        vehicle.turnRight();
        vehicle.startEngine();
    }


    boolean isOverlappingWall(Vehicle car) {
        return car.getX() <= 0 || car.getY() <= 0 || car.getX() >= 800 || car.getY() >= 800-240;
    }


}
