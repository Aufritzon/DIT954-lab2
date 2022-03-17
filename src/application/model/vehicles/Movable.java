package application.model.vehicles;

/**
 * application.application.model.vehicles.Movable is implemented by CarMovable.
 *
 * @see
 */
public interface Movable extends IPositionable {

    void move();

    void turnLeft();

    void turnRight();

}
