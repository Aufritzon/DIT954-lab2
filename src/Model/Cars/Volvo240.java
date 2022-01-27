package Model.Cars;

import Model.Base.Car;
import Model.Base.TrimmedEngine;

import java.awt.*;

/**
 * Volvo240 is used to create a new volvo object. It is initialized with its position (x, y), and direction. All its other
 * traits are set by default. This class includes a "trimfactor" field which is used in its TrimmedEngine
 * All of these are sent to the superclass {@link Car}
 */
public class Volvo240 extends Car {
    public final static double trimFactor = 1.25;

    public Volvo240(double x, double y, Direction dir){
        super(x,  y, dir,  4, Color.BLACK, "Volvo240", new TrimmedEngine(100, 0, trimFactor));
    }
}
