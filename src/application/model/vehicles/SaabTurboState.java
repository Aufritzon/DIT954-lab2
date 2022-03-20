package application.model.vehicles;

import java.util.List;

public class SaabTurboState implements ITurboState {

    private double factor = 1;

    public double getFactor() {
        return factor;
    }

    @Override
    public void on() {
        factor = 1.3;
    }

    @Override
    public void off() {
        factor = 1;
    }
}
