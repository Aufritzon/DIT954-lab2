package Model.Base;

import java.awt.*;

/**
 * Car handles all common traits among the cars. It stores the information of the cars, such as the number of doors,
 * color of the car, the model name and the type of engine the car is using. It contains methods that can be used to
 * retrieve this information but also change some of them.
 * The position, direction and movement is sent to and handled by the superclass {@link CarMovable}
 */
public abstract class Car extends CarMovable {

    private final int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    public final Engine engine;

    public Car (double x, double y, Direction dir, int nrDoors, Color color, String modelName, Engine engine){
        super(x, y, dir);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.engine = engine;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    //Moves the car in the direction it is currently facing with currentSpeed
    @Override
    public void move() {
        move(engine.getCurrentSpeed());
    }

    public void gas(double amount){
        testForSpeedException(amount);
        engine.incrementSpeed(amount);

    }

    public void brake(double amount) {
        testForSpeedException(amount);
        engine.decrementSpeed(amount);
    }

    private void testForSpeedException(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount can't be negative");
        } else if(!(0 <= amount && amount <= 1)) {
            throw new IllegalArgumentException("Amount must be between 0 and 1");
        }
    }

}
