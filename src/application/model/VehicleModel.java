package application.model;

public interface VehicleModel {

    void moveVehicles();

    void stopVehicles();

    void startVehicles();

    void gasVehicles(int amount);

    void brakeVehicles(int amount);

    void lowerBeds();

    void liftBeds();

    void turnOnTurbos();

    void turnOffTurbos();

    void addVehicle();

    void removeVehicle();


}
