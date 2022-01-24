package Model.Base;

public abstract class CarMovable extends AbstractPositionable implements Movable{

    public enum Direction{
        NORTH, SOUTH, EAST, WEST
    }

    private Direction dir;
    private double currentSpeed;
    private double enginePower;


    public CarMovable(double currentSpeed, double enginePower, double x, double y, Direction dir){
        super(x, y);
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.dir = dir;
    }

    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    //Moves the car in the direction it is currently facing with currentSpeed
    @Override
    public void move() {
        switch (dir) {
            case NORTH -> decreaseY(currentSpeed);
            case SOUTH -> increaseY(currentSpeed);
            case EAST -> increaseX(currentSpeed);
            case WEST -> decreaseX(currentSpeed);
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
