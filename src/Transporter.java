import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class Transporter extends TrailerTruck {

    private final static int LOADING_CAPACITY = 10;
    private final static int MIN_DISTANCE_FOR_LOADING = 5;
    private final static double MAX_WEIGHT_PER_CAR = 2.5;

    private boolean isTrailerRaised;
    private final Deque<Car> load = new LinkedList<>();

    public Transporter(double x, double y, Direction dir) {
        super(x, y, dir, 0, 2, Color.WHITE, "CarTransport", 100);
        this.isTrailerRaised = false;
    }

    public Deque<Car> getLoad() {
        return load;
    }

    public void raiseTrailer(){ isTrailerRaised = true;}

    public void lowerTrailer(){
        isTrailerRaised = false;
    }

    public void loadCar(Car car) {
        if (isRoomOnTrailer() && !isTrailerRaised && isCarCloseEnough(car) && !isCarTooBig(car)) {
            load.push(car);
            car.setX(getX());
            car.setY(getY());
        }
    }

    public void unloadCar() {
        if (!load.isEmpty() && !isTrailerRaised) {
            Car car = load.pop();
            car.setX(getX() + MIN_DISTANCE_FOR_LOADING);
        }
    }

    @Override
    public boolean isTrailerMovable() {
        return isTrailerRaised;
    }

    @Override
    public void move() {
        super.move();
        updateLoadPosition();
    }

    private boolean isRoomOnTrailer() { return load.size() != LOADING_CAPACITY;}

    private boolean isCarCloseEnough(Car car) {
        double distance = Math.sqrt(Math.pow(getX() - car.getX(), 2) + Math.pow(getY() - car.getY(), 2));
        return distance <= MIN_DISTANCE_FOR_LOADING;
    }

    private boolean isCarTooBig(Car car) {return car.getWeight() > MAX_WEIGHT_PER_CAR;}

    private void updateLoadPosition() {
        for (Car car : load) {
            car.setY(getY());
            car.setX(getX());
            car.setDir(getDir());
        }
    }
}
