import java.awt.*;

/**
 * Car handles all common traits among the cars. It stores the information of the cars, such as the number of doors,
 * color of the car, the model name and the type of engine the car is using. It contains methods that can be used to
 * retrieve this information but also change some of them.
 * The position, direction and movement is sent to and handled by the superclass {@link AbstractMovable}
 */
public abstract class Car extends Vehicle {


    public Car(double x, double y, Direction dir, double currentSpeed, int nrDoors, Color color, String modelName, double enginePower) {
        super(x, y, dir, currentSpeed, nrDoors, color, modelName, enginePower);
    }
}
