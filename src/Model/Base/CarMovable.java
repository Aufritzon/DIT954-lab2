package Model.Base;

public abstract class CarMovable implements Movable{
    private double currentSpeed;
    private double enginePower;
    private IPosition position;


    public CarMovable(double currentSpeed, double enginePower, double x, double y){
        super();
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.position = new CarPosition(x,y);
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

    @Override
    public IPosition getPosition() {
        return position;
    }

    @Override
    public void move(){};
    
    @Override
    public void turnLeft(){};
    
    @Override
    public void turnRight(){};

}
