package application.model.vehicles;

import java.awt.*;

/**
 * application.application.model.vehicles.Saab95 is used to create a new saab object. It is initialized with its position (x, y), and direction. All its other
 * traits are set by default. All of these are sent to the superclass {@link Car}
 */
public class Saab95 extends Car implements TurboVehicle {

    private final ITurboState turboState;

    public Saab95(double x, double y, Direction dir) {
        super(x, y, dir, 0, 4, Color.RED, "Saab95", 125, 2);
        this.turboState = new SaabTurboState();
        setImage("Saab95.jpg");
    }

    @Override
    public void setTurboOn() {
        turboState.on();
    }

    @Override
    public void setTurboOff() {
        turboState.off();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * turboState.getFactor();
    }

}

