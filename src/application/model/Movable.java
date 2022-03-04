package application.model;

/**
 * application.application.model.Movable is implemented by CarMovable.
 *
 * @see AbstractMovable
 */
public interface Movable extends IPositionable {

    void move();

    void turnLeft();

    void turnRight();

}
