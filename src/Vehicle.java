import java.awt.*;

public abstract class Vehicle extends AbstractMovable{

    private final int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private final double enginePower;

    public Vehicle (double x, double y, Direction dir, double currentSpeed,
                int nrDoors, Color color, String modelName, double enginePower){

        super(x, y, dir, currentSpeed);
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
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

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine() {
        setCurrentSpeed(0.1);
    }

    public void stopEngine() {
        setCurrentSpeed(0);
    }

    public void gas(double amount) {
        decrementSpeed(HelperMethods.valueWithinBounds(amount, 0, 1));
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
