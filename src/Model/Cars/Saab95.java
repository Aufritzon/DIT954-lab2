package Model.Cars;

import Model.Base.*;
import java.awt.*;

/**
 * Saab95 is used to create a new saab object. It is initialized with its position (x, y), and direction. All its other
 * traits are set by default. All of these are sent to the superclass {@link Car}
 */
public class Saab95 extends Car{

    public Saab95 (double x, double y, Direction dir) {
        super(x, y, dir , 2, Color.RED, "Saab95", new TurboEngine(125, 0, new Turbo(false)));
    }

}

