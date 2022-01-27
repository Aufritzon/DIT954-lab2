package Model.Base;

public abstract class CarMovable implements Movable{

    private Direction dir;
    private double x;
    private double y;

    public CarMovable(double x, double y, Direction dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    //Moves the car in the direction it is currently facing with currentSpeed
    public void move(double amount) {
        switch (dir) {
            case NORTH->  y -= amount;
            case SOUTH -> y += amount;
            case EAST -> x += amount;
            case WEST -> x -= amount;
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
