import java.awt.*;

public abstract class TrailerTruck extends Vehicle{
    private boolean isTrailerRaised;

    public TrailerTruck(double x, double y, Direction dir, double currentSpeed, int nrDoors, Color color, String modelName, double enginePower) {
        super(x, y, dir, currentSpeed, nrDoors, color, modelName, enginePower);
    }

    public void setIsTrailerRaised(boolean isTrailerRaised) {
        this.isTrailerRaised = isTrailerRaised;
    }


    abstract void lowerTrailer();

    abstract void raiseTrailer();




}
