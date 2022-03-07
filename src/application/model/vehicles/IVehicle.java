package application.model.vehicles;

import application.model.Drawable;
import application.model.Movable;

public interface IVehicle extends Movable, Drawable {
    void gas(double amount);
    void brake(double amount);
    void startEngine();
    void stopEngine();
    double getCurrentSpeed();
    void invertDirection();
}
