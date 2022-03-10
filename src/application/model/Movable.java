package application.model;

import application.view.IPositionable;

/**
 * application.application.model.Movable is implemented by CarMovable.
 *
 * @see
 */
public interface Movable extends IPositionable {

    void move();

    void turnLeft();

    void turnRight();

}
