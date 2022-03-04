package application.model;

import application.view.CarController;
import application.view.DrawPanel;
import application.view.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private static final String IMAGE_DIR = "/application/view/pics/";


    private List<Vehicle> vehicles = new ArrayList<>();
    private List<? extends IPositionable> positionables;
    private List<WorldObserver> observers = new ArrayList<>();
    private final Map<IPositionable,BufferedImage> positionalImageMap = new HashMap<>();
    public final static int WORLD_WIDTH = 800;
    public final static int WORLD_HEIGHT = 460;

    public World(WorldObserver observer) {
        vehicles.add(new Volvo240(0, 0, AbstractMovable.Direction.EAST));
        vehicles.add(new Saab95(0, 100, AbstractMovable.Direction.EAST));
        vehicles.add(new Scania(0, 200, AbstractMovable.Direction.EAST));
        this.observers.add(observer);
        updateWorldObservers();
    }

    private Point posToPoint (Position pos) {
        return new Point((int) Math.round(pos.getX()),  (int) Math.round(pos.getX()));
    }

    public void keepInsideWorld(Vehicle v) {
        if (!isInsideWorld(v)) {
            v.invertDirection();
            v.move();
            v.startEngine();
        }
    }


    private boolean isInsideWorld(Vehicle v) {
        double x = v.getPosition().getX();
        double y = v.getPosition().getY();
        BufferedImage image = v.getImage();
        double maxX = x + image.getWidth();
        double maxY = y + image.getHeight();

        boolean isAbove = y < 0;
        boolean isBelow = maxY > WORLD_HEIGHT;
        boolean isRightOff = maxX > WORLD_WIDTH;
        boolean isLeftOff = x < 0;

        return !(isAbove | isBelow | isRightOff | isLeftOff );
    }

    public World(List<Vehicle> vehicles, List<WorldObserver> observers) {
        this.vehicles = vehicles;
    }



    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Iterable<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setObservers(List<WorldObserver> observers) {
        this.observers = observers;
    }

    private void updateWorldObservers(){
        positionables = vehicles;
        for (WorldObserver o : observers) o.actOnWorld(positionables);
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

    public BufferedImage getImage(String fileName) throws IOException {
        BufferedImage image;
        InputStream inStream = getClass().getResourceAsStream(IMAGE_DIR + fileName);
        if (inStream == null) {
            throw new IllegalArgumentException("Image is missing: " + IMAGE_DIR + fileName);
        }
        image = ImageIO.read(inStream);
        return image;
    }

}
