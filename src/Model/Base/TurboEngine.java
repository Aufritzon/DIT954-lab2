package Model.Base;

public class TurboEngine extends Engine{

    public TurboEngine(double enginePower, double currentSpeed, boolean turboOn) {
        super(enginePower, currentSpeed, turboOn);
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (getTurboOn()) turbo = 1.3;
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
}
