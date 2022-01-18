import java.awt.*;

public abstract class Car {
    private final int nrDoors; // Number of doors on the car

    private final double enginePower; // Engine power of the car

    private double currentSpeed; // The current speed of the car

    private Color color; // Color of the car

    private final String modelName; // The car model name

    public Car (int doors, double engPow, double curSpeed, Color color, String modelName){
        this.nrDoors = doors;
        this.enginePower = engPow;
        this.currentSpeed = curSpeed;
        this.color = color;
        this.modelName = modelName;

    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    public String getModelName() {
        return modelName;
    }
}
