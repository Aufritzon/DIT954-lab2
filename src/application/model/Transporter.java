package application.model;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * creates a transporter object which represents a truck that transports cars.
 */
public class Transporter extends TrailerTruck {

    public final static int LOADING_CAPACITY = 10;
    public final static int MIN_DISTANCE_FOR_LOADING = 5;
    public final static double MAX_WEIGHT_PER_CAR = 2.5;

    private boolean isTrailerRaised;
    private final Deque<Car> load = new LinkedList<>();

    /**
     * Constructor for application.application.model.Transporter.
     * @param x
     * @param y
     * @param dir
     */
    public Transporter(double x, double y, Direction dir) {
        super(x, y, dir, 0, 2, Color.WHITE, "CarTransport", 100);
        this.isTrailerRaised = false;
    }

    /**
     * returns all the cars that are currently loaded on the transporter
     * @return
     */
    public Deque<Car> getLoad() {
        return load;
    }

    /**
     * Raises the trailer ramp.
     */
    public void raiseTrailer(){ isTrailerRaised = true;}

    /**
     * Lowers the trailer ramp.
     */
    public void lowerTrailer(){
        isTrailerRaised = false;
    }

    /**
     * Checks if theres room on the transporter for a car then loads the car into the transporter. Sets the position of
     * the car to be the same as the tranporters position.
     * @param car
     */
    public void loadCar(Car car) {
        if (isRoomOnTrailer() && !isTrailerRaised && isCarCloseEnough(car) && !isCarTooBig(car)) {
            load.push(car);
            car.setX(getX());
            car.setY(getY());
        }
    }

    /**
     * Checks if  the transporter is empty then unloads a car off the transporter. Sets the position of
     * the car to be the safe distance for loading from the tranporters position.
     */
    public void unloadCar() {
        if (!load.isEmpty() && !isTrailerRaised) {
            Car car = load.pop();
            car.setX(getX() + MIN_DISTANCE_FOR_LOADING);
        }
    }

    /**
     * Checks whether the transporter is driveable by checking if the trailer is raised
     * @return
     */
    @Override
    public boolean isTrailerMovable() {
        return isTrailerRaised;
    }

    /**
     * moves the transporter and updates the loaded cars position to be in line with the transporter
     */
    @Override
    public void move() {
        super.move();
        updateLoadPosition();
    }

    /**
     * checks if the load size is less than the max capacity
     * @return
     */
    private boolean isRoomOnTrailer() { return load.size() != LOADING_CAPACITY;}

    /**
     * checks if the car to be loaded is close enough to the transporters position
     * @param car
     * @return
     */
    private boolean isCarCloseEnough(Car car) {
        double distance = Math.sqrt(Math.pow(getX() - car.getX(), 2) + Math.pow(getY() - car.getY(), 2));
        return distance <= MIN_DISTANCE_FOR_LOADING;
    }

    /**
     * checks if the car is too big by checking that the weight of the car is less than the max weight per car
     * @param car
     * @return
     */
    private boolean isCarTooBig(Car car) {return car.getWeight() > MAX_WEIGHT_PER_CAR;}

    /**
     * updates the loaded cars position to be in line with the transporters position
     */
    private void updateLoadPosition() {
        for (Car car : load) {
            car.setY(getY());
            car.setX(getX());
            car.setDir(getDir());
        }
    }
}
