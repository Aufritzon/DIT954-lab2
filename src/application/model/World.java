package application.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class World implements WorldObservable{
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<WorldObserver> observers = new ArrayList<>();
    public final static int WORLD_WIDTH = 800;
    public final static int WORLD_HEIGHT = 460;

    public World() {
        vehicles.add(new Volvo240(0, 0, AbstractMovable.Direction.EAST));
        vehicles.add(new Saab95(0, 100, AbstractMovable.Direction.EAST));
        vehicles.add(new Scania(0, 200, AbstractMovable.Direction.EAST));
    }

    public void keepInsideWorld(Vehicle v) {
        if (!isInsideWorld(v)) {
            v.invertDirection();
            v.move();
            v.startEngine();
        }
    }

    @Override
    public void addObserver(WorldObserver observer) {
        observers.add(observer);
        observer.update(this);
    }

    @Override
    public void removeObserver(WorldObserver observer) {
        observers.remove(observer);
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

        return !(isAbove | isBelow | isRightOff | isLeftOff );
    }

    @Override
    public List<IPositionable> getPositionables() {
        return Collections.unmodifiableList(vehicles);
    }

    private Point posToPoint (Position pos) {
        return new Point((int) Math.round(pos.getX()),  (int) Math.round(pos.getY()));
    }

    private void updateWorldObservers(){
        for (WorldObserver o : observers) o.update(this);
    }

    public void moveVehicles(){
        for (Vehicle v : vehicles) {
            v.move();
            keepInsideWorld(v);
        }
        updateWorldObservers();
    }

    public void stopVehicles() {
        for (Vehicle v: vehicles) v.stopEngine();
    }

    public void startVehicles() {
        for (Vehicle v: vehicles) v.startEngine();
    }

    // Calls the gas method for each car once
    public void gasVehicles(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles
        ) {
            v.gas(gas);
        }
    }

    public void brakeVehicles(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles
        ) {
            car.brake(brake);
        }
    }

    public void lowerBeds() {
        for (Vehicle v : vehicles
        ) {
            if (v instanceof Scania){
                ((Scania) v).lowerTrailer();
            }
        }
    }

    public void raiseBeds() {
        for (Vehicle v : vehicles
        ) {
            if (v instanceof Scania){
                ((Scania) v).raiseTrailer(70);
            }
        }
    }

    public void turnOnTurbos() {
        for (Vehicle v : vehicles
        ) {
            if (v instanceof Saab95){
                ((Saab95) v).setTurboOn();
            }
        }
    }

    public void turnOffTurbos() {
        for (Vehicle v : vehicles
        ) {
            if (v instanceof Saab95){
                ((Saab95) v).setTurboOff();
            }
        }
    }
}
