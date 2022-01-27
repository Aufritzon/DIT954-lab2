package Model.Base;

/**
 * TurboEngine represents one of the types of engines the cars can use. This type uses a Turbo which is used
 * when calculating the speedfactor. The speedfactor is used to calcualate how much the speed will increase. The turbo
 * is either on or off. When its on the speedfactor is slightly larger which makes the engine slightly stronger.
 */
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
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
}
