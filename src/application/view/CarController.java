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
    List<application.model.Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        List<Drawable> drawables = new ArrayList<>();

        List<Vehicle> vehicles = List.of(
                new Volvo240(0, 0, AbstractMovable.Direction.EAST),
                new Saab95(0, 100, AbstractMovable.Direction.EAST) ,
                new Scania(0, 200, AbstractMovable.Direction.EAST)
        );

        for (Vehicle v : vehicles) {
            Drawable d = new Drawable(v.getModelName(), (int)(Math.round(v.getX())), (int)(Math.round(v.getY())));
            drawables.add(d);
        }

        cc.cars.addAll(vehicles);

        // Start a new application.application.view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, drawables);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * application.application.view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Vehicle v;
            Drawable d;
            for (int i = 0 ; i < cars.size(); i++) {
                v = cars.get(i);
                d = frame.drawPanel.getDrawables().get(i);

                int x1 = toInt(v.getX());
                int y1 = toInt(v.getY());

                v.move();

                int x2 = toInt(v.getX());
                int y2 = toInt(v.getY()) ;

                if(frame.drawPanel.isInsideDrawPanel(d, x2, y2)) {
                    frame.drawPanel.moveit(d, x2, y2);
                } else {
                    v.setX(x1);
                    v.setY(y1);
                    v.invertDirection();
                }
                frame.drawPanel.repaint();
            }
        }
        private int toInt (double d) {
           return (int) Math.round(d);
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

    void startEngine() {
        for (Vehicle car : cars
        ) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars
        ) {
            car.stopEngine();
        }
    }

    void lowerBed() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Scania){
                ((Scania) car).lowerTrailer();
            }
        }
    }

    void raiseBed() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Scania){
                ((Scania) car).raiseTrailer(70);
            }
        }
    }

    void turboOn() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }
}
