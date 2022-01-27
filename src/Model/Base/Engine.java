package Model.Base;

public abstract class Engine {
    private double enginePower;
    private double currentSpeed;
    private boolean turboOn;

    public Engine(double enginePower, double currentSpeed, boolean turboOn) {
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.turboOn = turboOn;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    public void setTurboOn(boolean turboOn) {
        this.turboOn = turboOn;
    }

    public abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);
    protected abstract void decrementSpeed(double amount);
}
