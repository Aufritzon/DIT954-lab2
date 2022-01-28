package Model.Base;

/**
 * TrimmedEngine represents one of the types of engines the cars can use. This type uses a trimfactor which is used
 * when calculating the speedfactor. The speedfactor is used to calcualate how much the speed will increase.
 */
public class TrimmedEngine extends Engine{

    private final double trimFactor;

    public TrimmedEngine(double power, double speed, double trimFactor) {
        super(power,speed);
        this.trimFactor = trimFactor;
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
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
