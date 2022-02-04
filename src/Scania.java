import java.awt.*;

public class Scania extends TrailerTruck {

    public static final double MAX_TRAILER_ANGLE = 70;

    private double trailerAngle;

    public Scania(double x, double y, Direction dir) {
        super(x, y, dir, 0, 2, Color.BLUE, "Scania", 100);
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
        }
    }

    @Override
    public boolean isTrailerMovable() {
        return trailerAngle == 0;
    }

    public double getTrailerAngle() {
        return trailerAngle;
    }


}
