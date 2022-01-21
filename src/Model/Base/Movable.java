package Model.Base;

public interface Movable {
    IPosition getPosition();
    void move();
    void turnLeft();
    void turnRight();
}
