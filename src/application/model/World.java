package application.model;

import java.util.ArrayList;

import java.util.List;

public class World implements VehicleModel {

    public final static int WIDTH = 800;
    public final static int HEIGHT = WIDTH - 240;

    private final List<WorldListener> listeners = new ArrayList<>();
    private final Vehicles vehicles = new Vehicles();

    public void moveVehicles() {
        vehicles.move();
        notifyListeners();
    }

    @Override
    public Vehicles getVehicles() {
        return vehicles;
    }

    @Override
    public void stopVehicles() {
        vehicles.stopEngine();
    }

    @Override
    public void startVehicles() {
        vehicles.startEngine();
    }

    @Override
    // Calls the gas method for each car once
    public void gasVehicles(int amount) {
        vehicles.gas(amount);
    }

    @Override
    public void brakeVehicles(int amount) {
        vehicles.brake(amount);
    }

    @Override
    public void lowerBeds() {
        vehicles.lowerBed();
    }

    @Override
    public void liftBeds() {
        vehicles.liftBed();
    }

    @Override
    public void turnOnTurbos() {vehicles.turboOn();}

    @Override
    public void turnOffTurbos() {
        vehicles.turboOff();
    }

    public void addListener(WorldListener listener) {
        listeners.add(listener);
    }

    public void removeListener(WorldListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        listeners.forEach(l -> l.actOnWorldChange(vehicles.getPositionables()));
    }
}
