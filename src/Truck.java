import java.awt.*;

public abstract class Truck extends Vehicle{

    public Truck(double x, double y, Direction dir, double currentSpeed, int nrDoors, Color color, String modelName, double enginePower) {
        super(x, y, dir, currentSpeed, nrDoors, color, modelName, enginePower);
    }

}
