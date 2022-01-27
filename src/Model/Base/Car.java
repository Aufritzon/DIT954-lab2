package Model.Base;

import java.awt.*;

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
        engine.speedFactor();
        engine.incrementSpeed(amount);
    }

    public void brake(double amount){
        engine.decrementSpeed(amount);
    }

}
