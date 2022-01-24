package Model.Base;

abstract class AbstractPositionable implements Positionable {
    private double x;
    private double y;

    public AbstractPositionable(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void increaseX(double amount) {
        x += amount;
    }

    public void decreaseX(double amount) {
        x -= amount;
    }

    public void increaseY(double amount) {
        y += amount;
    }

    public void decreaseY(double amount) {
        y -= amount;
    }

    @Override
    public double getX(){
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }
}
