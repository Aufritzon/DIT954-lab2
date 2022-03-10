package application.model.world;

import application.controller.VehicleModel;
import application.model.vehicles.*;
import application.view.IPositionable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class World implements VehicleModel {

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = WORLD_WIDTH - 240;

    private final List<WorldListener> listeners = new ArrayList<>();
    private final Vehicles vehicles = new Vehicles();

    public World() {
        vehicles.addVehicle(new Volvo240(0, 0, Direction.EAST));
        vehicles.addTurboVehicle(new Saab95(0, 100, Direction.EAST));
        vehicles.addTrailerVehicle(new Scania(0, 200, Direction.EAST));
    }

    public void keepInsideWorld(IVehicle v) {
        if (!isInsideWorld(v)) {
            v.invertDirection();
            v.move();
            v.startEngine();
        }
    }

    private boolean isInsideWorld(IPositionable p) {
        double x = p.getPosition().getX();
        double y = p.getPosition().getY();
        BufferedImage image = p.getImage();
        double maxX = x + image.getWidth();
        double maxY = y + image.getHeight();

        boolean isAbove = y < 0;
        boolean isBelow = maxY > WORLD_HEIGHT;
        boolean isRightOff = maxX > WORLD_WIDTH;
        boolean isLeftOff = x < 0;

        return !(isAbove | isBelow | isRightOff | isLeftOff);
    }

    public void moveVehicles() {
        for (IVehicle v : vehicles.getVehicles()) {
            v.move();
            keepInsideWorld(v);
        }
        notifyListeners();
    }

    @Override
    public void stopVehicles() {
        vehicles.getVehicles().forEach(IVehicle::stopEngine);
    }

    @Override
    public void startVehicles() {
        vehicles.getVehicles().forEach(IVehicle::startEngine);
    }

    @Override
    // Calls the gas method for each car once
    public void gasVehicles(int amount) {
        double gas = ((double) amount) / 100;
        vehicles.getVehicles().forEach(v -> v.gas(gas));
    }

    @Override
    public void brakeVehicles(int amount) {
        double brake = ((double) amount) / 100;
        vehicles.getVehicles().forEach(v -> v.brake(brake));
    }

    @Override
    public void lowerBeds() {
        vehicles.getTrailerVehicles().forEach(TrailerVehicle::lowerTrailer);
    }

    @Override
    public void liftBeds() {
        vehicles.getTrailerVehicles().forEach(TrailerVehicle::raiseTrailer);
    }

    @Override
    public void turnOnTurbos() {
        vehicles.getTurboVehicles().forEach(TurboVehicle::setTurboOn);
    }

    @Override
    public void turnOffTurbos() {
        vehicles.getTurboVehicles().forEach(TurboVehicle::setTurboOff);
    }

    @Override
    public void addVehicle() {


    }

    @Override
    public void removeVehicle() {

    }



    private List<IPositionable> getPositionables() {
        return Collections.unmodifiableList(vehicles.getVehicles());
    }

    public void addListener(WorldListener listener) {
        listeners.add(listener);
    }

    public void removeListener(WorldListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        listeners.forEach(l -> l.actOnWorldChange(getPositionables()));
    }
}
