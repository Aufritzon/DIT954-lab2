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
     * abstract method to be implemented by the subclasses
     * @return
     */
    public abstract boolean isTrailerMovable();

    /**
     * Increases the currentspeed with an amount as long as the speed is more than 0 and less than the enginepower.
     * @param amount
     */
    @Override
    public void incrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() + amount);
    }

    /**
     * calculates the speed factor which is used to calculate the speed
     * @return
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Decreases the currentspeed with an amount as long as the speed is more than 0 and less than the enginepower.
     * @param amount
     */
    @Override
    public void decrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() + amount);
    }

    /**
     * Sets the currentspeed with an amount as long as the speed is more than 0 and less than the enginepower.
     * @param speed
     */
    private void setSafeSpeed(double speed) {
        if(isTrailerMovable()) {
            setBoundedSpeed(speed);
        }
    }
}