import java.awt.*;

public class Scania extends Truck {

    public static final double MAX_TRAILER_ANGLE = 70;

    private double trailerAngle;
    private final Trailer trailer;

    public Scania(double x, double y, Direction dir) {
        super(x, y, dir, 0, 2, Color.BLUE, "Scania", 100);
        this.trailer = new Trailer(false);
    }

    public void raiseTrailer (double amount) {
        setSafeTrailerAngle(trailerAngle + amount);
    }

    public void lowerTrailer (double amount){
        setSafeTrailerAngle(trailerAngle - amount);
    }

    public void lowerTrailer() {
        setSafeTrailerAngle(0);
    }

    public void setSafeTrailerAngle(double angle) {
        if(getCurrentSpeed() == 0) {
            trailerAngle = HelperMethods.valueWithinBounds(angle, 0 , MAX_TRAILER_ANGLE);
            trailer.setIsTrailerRaised(trailerAngle != 0);
        }
    }

    public void setSafeSpeed(double speed) {
        if(!trailer.isTrailerRaised()) {
            setBoundedSpeed(speed);
        }
    }

    public double getTrailerAngle() {
        return trailerAngle;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        setSafeSpeed(getCurrentSpeed() - speedFactor() * amount);
    }


}
