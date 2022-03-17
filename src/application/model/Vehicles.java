package application.model;

import application.model.vehicles.Direction;
import application.model.vehicles.TurboVehicle;
import application.model.vehicles.IVehicle;
import application.model.vehicles.TrailerVehicle;
import application.model.vehicles.IPositionable;

import java.awt.image.BufferedImage;
import java.util.*;

import static application.model.VehicleFactory.createVehicle;


public class Vehicles {

    private final static int MAX_VEHICLES = 10;

    private Deque<IVehicle> vehicles;

    public Vehicles() {
        initVehicles();
    }

    private void initVehicles() {
        vehicles = new LinkedList<>();
        this.add(createVehicle(VehicleType.SAAB95, 0, 0, Direction.EAST));
        this.add(createVehicle(VehicleType.VOLVO240, 0, 100, Direction.EAST));
        this.add(createVehicle(VehicleType.SCANIA,0, 200, Direction.EAST));
    }

    private void add(IVehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void remove() {
        if (!vehicles.isEmpty()) {
            vehicles.removeLast();
        }
    }

    public void add() {
        if(vehicles.size() < MAX_VEHICLES) {
            this.add(createVehicle());
        }
    }

    public void gas(double amount) {
        double gas = ((double) amount) / 100;
        vehicles.forEach(v -> v.gas(gas));
    }

    public void brake(double amount) {
            double brake = ((double) amount) / 100;
            vehicles.forEach(v -> v.brake(brake));
    }

    public void startEngine() {
        vehicles.forEach(IVehicle::startEngine);
    }

    public void stopEngine() {
        vehicles.forEach(IVehicle::stopEngine);

    }

    public void turboOn (){
        for (IVehicle v : vehicles) {
            if ((v instanceof TurboVehicle)) {
                ((TurboVehicle) v).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (IVehicle v : vehicles) {
            if ((v instanceof TurboVehicle)) {
                ((TurboVehicle) v).setTurboOff();
            }
        }
    }

    public void lowerBed() {
        for (IVehicle v : vehicles) {
            if ((v instanceof TrailerVehicle)) {
                ((TrailerVehicle) v).lowerTrailer();
            }
        }
    }

    public void liftBed() {
        for (IVehicle v : vehicles) {
            if ((v instanceof TrailerVehicle)) {
                ((TrailerVehicle) v).raiseTrailer();
            }
        }
    }

    public List<IPositionable> getPositionables() {
        return Collections.unmodifiableList(new ArrayList<>(vehicles));
    }

    public void keepInsideWorld(IVehicle v) {
        if (!isInsideWorld(v)) {
            v.invertDirection();
            v.move();
            v.stopEngine();
            v.startEngine();
        }
    }

    private boolean isInsideWorld(IPositionable p) {
        double x = p.getX();
        double y = p.getY();
        BufferedImage image = p.getImage();
        double maxX = x + image.getWidth();
        double maxY = y + image.getHeight();

        boolean isAbove = y < 0;
        boolean isBelow = maxY > World.HEIGHT;
        boolean isRightOff = maxX > World.WIDTH;
        boolean isLeftOff = x < 0;

        return !(isAbove | isBelow | isRightOff | isLeftOff);
    }

    public void move() {
        for (IVehicle v : vehicles) {
            v.move();
            keepInsideWorld(v);
        }
    }
}
