package application.model.vehicles;

import application.model.HelperMethods;
import application.model.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * implemented by car and trailertruck. Holds all common traits and all common functionality between them
 */
public abstract class Vehicle implements IVehicle {

    private final int nrDoors; // Number of doors on the car
    private final String modelName; // The car application.application.model name
    private final double enginePower;
    private Color color; // Color of the car
    private BufferedImage image;
    private Position position;
    private Direction dir;
    private double currentSpeed;

    /**
     * constructor for application.application.model.vehicles.Vehicle
     *
     * @param x
     * @param y
     * @param dir
     * @param currentSpeed
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     */
    public Vehicle(double x, double y, Direction dir, double currentSpeed,
                   int nrDoors, Color color, String modelName, double enginePower) {
        this.position = new Position(x, y);
        this.dir = dir;
        this.currentSpeed = currentSpeed;
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.image = null;
    }

    /**
     * returns the number of doors on the vehicle
     *
     * @return nrDoors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * returns the color of the vehicle
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * sets the color of the vehicle
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * returns the application.application.model name of the vehicle
     *
     * @return modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * returns the engine power of the vehicle
     *
     * @return enginePower
     */
    public double getEnginePower() {
        return enginePower;
    }

    @Override
    public void startEngine() {
        stopEngine();
        incrementSpeed(0.1);
    }

    public void invertDirection() {
        turnRight();
        turnRight();
    }

    @Override
    public void stopEngine() {
        setCurrentSpeed(0);
    }

    @Override
    public void gas(double amount) {
        incrementSpeed(HelperMethods.valueWithinBounds(amount, 0, 1));
    }

    @Override
    public void brake(double amount) {
        decrementSpeed(HelperMethods.valueWithinBounds(amount, 0, 1));
    }

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public abstract double speedFactor();

    @Override
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(String fileName) {
        String image_dir = "/application/view/pics/";
        try {
            image = ImageIO.read(getClass().getResourceAsStream(image_dir + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBoundedSpeed(double speed) {
        setCurrentSpeed(HelperMethods.valueWithinBounds(speed, 0, getEnginePower()));
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public double getX() {
        return position.getX();
    }

    public void setX(double x) {
        this.position.setX(x);
    }

    @Override
    public double getY() {
        return position.getY();
    }

    public void setY(double y) {
        this.position.setY(y);
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    //Moves the car in the direction it is currently facing with currentSpeed

    @Override
    public void move() {
        switch (dir) {
            case NORTH -> setY(getY() - currentSpeed);
            case SOUTH -> setY(getY() + currentSpeed);
            case EAST -> setX(getX() + currentSpeed);
            case WEST -> setX(getX() - currentSpeed);
        }
    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case NORTH -> dir = Direction.WEST;
            case SOUTH -> dir = Direction.EAST;
            case EAST -> dir = Direction.NORTH;
            case WEST -> dir = Direction.SOUTH;
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case NORTH -> dir = Direction.EAST;
            case SOUTH -> dir = Direction.WEST;
            case EAST -> dir = Direction.SOUTH;
            case WEST -> dir = Direction.NORTH;
        }
    }
}
