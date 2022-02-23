package application.model;

/**
 *  CarMovable handles all movement and direction changes for the cars. The methods in this class are used to change
 *  direction and position by applying the move(), turnLeft() and turnRight() on the cars.
 *  This class implements the interface {@link Movable}
 */
public abstract class AbstractMovable implements Movable {

    private double x;
    private double y;
    private Direction dir;
    private double currentSpeed;

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public AbstractMovable(double x, double y, Direction dir, double currentSpeed) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.currentSpeed = currentSpeed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    //Moves the car in the direction it is currently facing with currentSpeed

    @Override
    public void move() {
        switch (dir) {
            case NORTH -> y -= currentSpeed;
            case SOUTH -> y += currentSpeed;
            case EAST -> x += currentSpeed;
            case WEST -> x -= currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case NORTH -> dir = Direction.WEST;
            case SOUTH -> dir = Direction.EAST;
            case EAST -> dir = Direction.NORTH;
            case WEST -> dir = Direction.SOUTH;
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case NORTH -> dir = Direction.EAST;
            case SOUTH -> dir = Direction.WEST;
            case EAST -> dir = Direction.SOUTH;
            case WEST -> dir = Direction.NORTH;
        }
    }
}
