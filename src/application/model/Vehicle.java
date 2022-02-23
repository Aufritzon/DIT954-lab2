package application.model;

import java.awt.*;

/**
 * implemented by car and trailertruck. Holds all common traits and all common functionality between them
 */
public abstract class Vehicle extends AbstractMovable{

    private final int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private final String modelName; // The car application.application.model name
    private final double enginePower;

    /**
     * constructor for application.application.model.Vehicle
     * @param x
     * @param y
     * @param dir
     * @param currentSpeed
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     */
    public Vehicle (double x, double y, Direction dir, double currentSpeed,
                int nrDoors, Color color, String modelName, double enginePower){

        super(x, y, dir, currentSpeed);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
    }

    /**
     * returns the number of doors on the vehicle
     * @return nrDoors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * returns the color of the vehicle
     * @return color
     */
    public Color getColor(){
        return color;
    }

    /**
     * sets the color of the vehicle
     * @param color
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * returns the application.application.model name of the vehicle
     * @return modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * returns the engine power of the vehicle
     * @return enginePower
     */
    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine() {
        stopEngine();
        incrementSpeed(0.1);
    }

    public void invertDirection() {
        turnRight();
        turnRight();
        startEngine();
    }

    public void stopEngine() {
        setCurrentSpeed(0);
    }

    public void gas(double amount) {
        incrementSpeed(HelperMethods.valueWithinBounds(amount, 0, 1));
    }

    public void brake(double amount) {
        decrementSpeed(HelperMethods.valueWithinBounds(amount, 0, 1));
    }

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public abstract double speedFactor();

    public void setBoundedSpeed(double speed) {
            setCurrentSpeed(HelperMethods.valueWithinBounds(speed, 0, getEnginePower()));
    }
}
