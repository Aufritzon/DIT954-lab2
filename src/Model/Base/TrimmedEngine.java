package Model.Base;

public class TrimmedEngine extends Engine{

    private final double trimFactor;

    public TrimmedEngine(double power, double speed, double trimFactor) {
        super(power,speed,false);
        this.trimFactor = trimFactor;
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
}
