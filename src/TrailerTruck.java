import java.awt.*;

/**
 * Is implemented by the transporter and Scania truck. Controls the speed for both of them.
 */
public abstract class TrailerTruck extends Vehicle{

    public TrailerTruck(double x, double y, Direction dir, double currentSpeed,
                        int nrDoors, Color color, String modelName, double enginePower) {
        super(x, y, dir, currentSpeed, nrDoors, color, modelName, enginePower);
    }

    /**
     * Each subclass decide when their trailer is in a movable state.
     * @return
     */
    public abstract boolean isTrailerMovable();

    /**
     * Safely increases the speed by an amount.
     * @param amount
     */
    @Override
    public void incrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() + amount);
    }

    /**
     * Safely decreases the speed by an amount.
     * @param amount
     */
    @Override
    public void decrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() + amount);
    }

    /**
     * Calculates the speed factor from which to calculate the speed.
     * @return
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Sets the speed as long as the trailer is able to move,
     * and the speed >0 and <= enginePower,and the trailer is able to move.
     * @param speed
     */
    private void setSafeSpeed(double speed) {
        if(isTrailerMovable()) {
            setBoundedSpeed(speed);
        }
    }
}