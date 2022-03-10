package application.controller;

import application.view.ViewListener;

public class VehicleController implements ViewListener {

    private final VehicleModel world;

    public VehicleController(VehicleModel world) {
        this.world = world;
    }

    @Override
    public void gasPerformed(int gasAmount) {
        world.gasVehicles(gasAmount);
    }

    @Override
    public void brakePerformed(int gasAmount) {
        world.brakeVehicles(gasAmount);
    }

    @Override
    public void turboOnPerformed() {
        world.turnOnTurbos();
    }

    @Override
    public void turboOffPerformed() {
        world.turnOffTurbos();
    }

    @Override
    public void startPerformed() {
        world.startVehicles();
    }

    @Override
    public void stopPerformed() {
        world.stopVehicles();
    }

    @Override
    public void liftBedPerformed() {
        world.liftBeds();
    }

    @Override
    public void lowerBedPerformed() {
        world.lowerBeds();
    }

    @Override
    public void addVehiclePerformed() {

    }

    @Override
    public void removeVehiclePerformed() {

    }

}
