package application.model.vehicles;

public interface IVehicle extends Movable {
    void gas(double amount);

    void brake(double amount);

    void startEngine();

    void stopEngine();

    void invertDirection();
}
