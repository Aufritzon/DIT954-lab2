package application.model;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Creates a application.application.model.Scania object which represents a truck. It's initialised with its position and direction.
 */
public class Scania extends TrailerTruck {

    /**
     * max angle for the trailer
     */
    public static final double MAX_TRAILER_ANGLE = 70;

    /**
     * the current angle of the trailer
     */
    private double trailerAngle;

    /**
     * Constructor for application.application.model.Scania object.
     * @param x x position
     * @param y y position
     * @param dir direction
     */
    public Scania(double x, double y, Direction dir) {
        super(x, y, dir, 0, 2, Color.BLUE, "Scania", 100);
        setImage("Scania.jpg");
    }

    /**
     * Raises the trailer with an amount if the amount falls within a safe interval.
     * @param amount
     */

    public void raiseTrailer (double amount) {
        setSafeTrailerAngle(trailerAngle + amount);
    }

    /**
     * Lowers the trailer with an amount if the amount falls within a safe interval.
     * @param amount
     */
    public void lowerTrailer (double amount){
        setSafeTrailerAngle(trailerAngle - amount);
    }

    /**
     * Lowers the trailer to zero
     */
    public void lowerTrailer() {
        setSafeTrailerAngle(0);
    }

    /**
     * Sets the trailer angle to a fixed angle.
     * @param angle
     */
    public void setSafeTrailerAngle(double angle) {
        if(getCurrentSpeed() == 0) {
            trailerAngle = HelperMethods.valueWithinBounds(angle, 0 , MAX_TRAILER_ANGLE);
        }
    }

    /**
     * Checks if the truck is able to drive by checking if the trailer is down.
     * @return
     */
    @Override
    public boolean isTrailerMovable() {
        return trailerAngle == 0;
    }

    /**
     * Returns the current trailer angle
     * @return
     */
    public double getTrailerAngle() {
        return trailerAngle;
    }

}
