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

    public abstract double speedFactor();

    public void gas(double amount) {
        testForSpeedException(amount);
        incrementSpeed(amount);
    }

    public abstract void incrementSpeed(double amount);

    public void brake(double amount) {
        testForSpeedException(amount);
        decrementSpeed(amount);
    }

    public abstract void decrementSpeed(double amount);

    private void testForSpeedException(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount can't be negative");
        } else if(!(0 <= amount && amount <= 1)) {
            throw new IllegalArgumentException("Amount must be between 0 and 1");
        }
    }
}
