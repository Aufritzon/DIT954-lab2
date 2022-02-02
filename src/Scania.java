import java.awt.*;
import java.math.*;

public class Scania extends TrailerTruck {

    private double trailerAngle;
    public static final double MAX_TRAILER_ANGLE = 70;
    public static final double MIN_TRAILER_ANGLE = 0;

    public Scania(double x, double y, Direction dir, double currentSpeed, int trailerAngle) {
        super(x, y, dir, currentSpeed, 2, Color.BLUE, "Scania", 100);
        this.trailerAngle = trailerAngle;
        setIsTrailerRaised(trailerAngle != 0);
    }


    public void lowerTrailer (double amount){
        if (getCurrentSpeed() == 0){
            trailerAngle ==
        }

        if (amount == 0) {
            setIsTrailerRaised(false);
        }

    }

    public double getTrailerAngle() {
        return trailerAngle;
    }

    public void setTrailerAngle(double angle) {
        trailerAngle = validTrailerAngle(angle);
    }

    private double validTrailerAngle (double angle) {
        return angle > MAX_TRAILER_ANGLE ? MAX_TRAILER_ANGLE : Math.max(angle, MIN_TRAILER_ANGLE);
    }



    public void raiseTrailer(double amount) {
        double newAngle = trailerAngle + amount;
        if (getCurrentSpeed() == 0) {
        }

        if (amount != 0) {
            setIsTrailerRaised(true);
        }
    }




    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        if (trailerAngle == 0){
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        }
    }

    @Override
    public void decrementSpeed(double amount) {
        if (trailerAngle == 0) {
            setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        }
    }
}
