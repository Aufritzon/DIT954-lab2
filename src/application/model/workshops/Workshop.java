package application.model.workshops;

import application.model.vehicles.Car;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Generic type representing car workshops.
 * Can be instantiated for specific car-types or just cars in general.
 * @param <T>
 */
public class Workshop <T extends Car> {
    private final int capacity;

    Deque<T> cars = new LinkedList<>();

    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns the maximum number of cars that can be stored in the workshop.
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Adds another car to the workshop, parked behind the others.
     * @param car
     */
    public void storeCar (T car){
        if (cars.size() < capacity) {
            cars.push(car);
        }
    }

    /**
     * Gives back the car that was most recently added to the shop.
     * @return
     */
    public T retrieveCar() {
        return cars.pop();
    }

}
