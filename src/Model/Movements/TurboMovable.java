package Model.Movements;

import Model.Base.CarMovable;

public class TurboMovable extends CarMovable {
    private boolean turboOn;

    public TurboMovable(double currentSpeed, double enginePower, double x, double y, Direction dir) {
        super(currentSpeed, enginePower, x, y, dir);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    // TODO fix this method according to lab pm
/*
    public void gas(double amount){
        incrementSpeed(amount);
    }
*/
/*
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
*/
}
