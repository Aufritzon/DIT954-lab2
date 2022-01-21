package Model.Base;

public class CarPosition implements IPosition{
    private double x;
    private double y;

    public CarPosition(double x, double y) {
        this.x = x;
        this.y = y;
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
