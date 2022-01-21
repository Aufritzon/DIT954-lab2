package Model.Movements;


import Model.Base.CarMovable;

public class TrimmedMovable extends CarMovable {
    public final static double trimFactor = 1.25;

    public TrimmedMovable(double currentSpeed, double enginePower, double x, double y) {
        super(currentSpeed, enginePower, x, y);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /*
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
*/
}
