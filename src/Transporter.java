import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class Transporter extends Truck {

    private final static int CAPACITY = 10;
    private final static int MIN_DISTANCE_FOR_LOADING = 5;

    private final Trailer trailer;
    private final Deque<Car> cars = new LinkedList<>();

    public Transporter(double x, double y, Direction dir) {
        super(x, y, dir, 0, 2, Color.WHITE, "CarTransport", 100);
        this.trailer = new Trailer(false);
    }

    public void raiseTrailer(){
        trailer.setIsTrailerRaised(true);
    }

    public Deque<Car> getCars() {
        return cars;
    }

    public void lowerTrailer(){
        trailer.setIsTrailerRaised(false);
    }

    public void loadCar(Car car) {
        if (cars.size() != CAPACITY && !trailer.isTrailerRaised() && isCarCloseEnough(car)) {
            cars.push(car);
            car.setX(getX());
            car.setY(getY());
        }
    }

    private boolean isCarCloseEnough(Car car) {
        double distance = Math.sqrt(Math.pow(getX() - car.getX(), 2) + Math.pow(getY() - car.getY(), 2));
        return distance <= MIN_DISTANCE_FOR_LOADING;
    }

    public void unloadCar() {
        if (!cars.isEmpty() && !trailer.isTrailerRaised()) {
            Car car = cars.pop();
            car.setX(getX() + MIN_DISTANCE_FOR_LOADING);
        }
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

    private void setSafeSpeed(double speed) {
        if(trailer.isTrailerRaised()) {
            setBoundedSpeed(speed);
        }
    }

    @Override
    public void move() {
        super.move();
        updateLoadPosition();
    }

    private void updateLoadPosition() {
        for (Car car : cars) {
            car.setY(getY());
            car.setX(getX());
            car.setDir(getDir());
        }
    }
}
