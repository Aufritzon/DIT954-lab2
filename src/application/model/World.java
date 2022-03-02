package application.model;

import application.view.DrawPanel;
import application.view.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class World {
    private static final String IMAGE_DIR = "/application/view/pics/";

    private List<Vehicle> vehicles;
    private List<WorldObserver> observers;
    public final static int WORLD_WIDTH = 800;
    public final static int WORLD_HEIGHT = 460;


    boolean isInsideWorld(String s, int x, int y) {
        BufferedImage image = null;
        try {
            image = getImage(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int maxX = x + image.getWidth();
        int maxY = y + image.getHeight();

        boolean isAbove = y < 0;
        boolean isBelow = maxY > this.getHeight();
        boolean isRightOff = maxX > this.getWidth();
        boolean isLeftOff = x < 0;

        return !(isAbove | isBelow | isRightOff | isLeftOff );
    }

    public World(List<Vehicle> vehicles, List<WorldObserver> observers) {
        this.vehicles = vehicles;
    }

    public World() {
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
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
        List<Integer> names = new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        for (Vehicle v : vehicles) {
            names.add(v.hashCode());
            positions.add(v.getPosition());
        }
        for (WorldObserver o : observers) o.actOnWorld(names, positions);
    }

    public void moveVehicles(){
        for (Vehicle v : vehicles) {
            v.move();
            updateWorldObservers();
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
        InputStream inStream = DrawPanel.class.getResourceAsStream(IMAGE_DIR + fileName);
        if (inStream == null) {
            throw new IllegalArgumentException("Image is missing: " + IMAGE_DIR + fileName);
        }
        image = ImageIO.read(inStream);
        return image;
    }

}
