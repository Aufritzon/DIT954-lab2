package application.model.world;

import application.controller.WorldModel;
import application.model.Direction;
import application.model.Drawable;
import application.model.vehicles.*;

import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class World implements WorldModel {

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = WORLD_WIDTH - 240;

    private Vehicles vehicles = new Vehicles();

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

    private boolean isInsideWorld(Drawable d) {
        double x = d.getPosition().getX();
        double y = d.getPosition().getY();
        BufferedImage image = d.getImage();
        double maxX = x + image.getWidth();
        double maxY = y + image.getHeight();

        boolean isAbove = y < 0;
        boolean isBelow = maxY > WORLD_HEIGHT;
        boolean isRightOff = maxX > WORLD_WIDTH;
        boolean isLeftOff = x < 0;

        return !(isAbove | isBelow | isRightOff | isLeftOff );
    }

    @Override
    public List<Drawable> getDrawables() {
        return Collections.unmodifiableList(vehicles.getVehicles());
    }

    public void moveVehicles(){
        for (IVehicle v : vehicles.getVehicles()) {
            v.move();
            keepInsideWorld(v);
        }
    }

    @Override
    public void stopVehicles() {
        for (IVehicle v: vehicles.getVehicles()) v.stopEngine();
    }

    @Override
    public void startVehicles() {
        for (IVehicle v: vehicles.getVehicles()) v.startEngine();
    }

    @Override
    // Calls the gas method for each car once
    public void gasVehicles(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle v : vehicles.getVehicles()
        ) {
            v.gas(gas);
        }
    }

    @Override
    public void brakeVehicles(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle v : vehicles.getVehicles()
        ) {
            v.brake(brake);
        }
    }

    @Override
    public void lowerBeds() {
        for (TrailerVehicle v : vehicles.getTrailerVehicles()
        ) {
            v.lowerTrailer();
        }
    }

    @Override
    public void raiseBeds() {
        for (TrailerVehicle v : vehicles.getTrailerVehicles()
        ) {
            v.raiseTrailer();
        }
    }

    @Override
    public void turnOnTurbos() {
        for (TurboVehicle v : vehicles.getTurboVehicles())
        {
            v.setTurboOn();
        }
    }

    @Override
    public void turnOffTurbos() {
        for (TurboVehicle v : vehicles.getTurboVehicles())
        {
            v.setTurboOff();
        }
    }
}
