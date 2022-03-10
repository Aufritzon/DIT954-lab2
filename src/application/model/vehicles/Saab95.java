package application.model.vehicles;

import java.awt.*;

/**
 * application.application.model.vehicles.Saab95 is used to create a new saab object. It is initialized with its position (x, y), and direction. All its other
 * traits are set by default. All of these are sent to the superclass {@link Car}
 */
public class Saab95 extends Car implements TurboVehicle {

    private boolean turboOn;

    public Saab95(double x, double y, Direction dir) {
        super(x, y, dir, 0, 4, Color.RED, "Saab95", 125, 2);
        this.turboOn = false;
        setImage("Saab95.jpg");
    }

    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    @Override
    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double val = 1;
        if (turboOn) val = 1.3;
        return getEnginePower() * 0.01 * val;
    }

}

