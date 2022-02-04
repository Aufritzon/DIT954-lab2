import java.awt.*;

public abstract class TrailerTruck extends Vehicle{

    public TrailerTruck(double x, double y, Direction dir, double currentSpeed,
                        int nrDoors, Color color, String modelName, double enginePower) {
        super(x, y, dir, currentSpeed, nrDoors, color, modelName, enginePower);
    }

    public abstract boolean isTrailerMovable();

    @Override
    public void incrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() + amount);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void decrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() + amount);
    }

    private void setSafeSpeed(double speed) {
        if(isTrailerMovable()) {
            setBoundedSpeed(speed);
        }
    }
}