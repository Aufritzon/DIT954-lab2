package src;

import java.awt.*;

public class Saab95 extends Car implements Movable{

    public boolean turboOn;

    //random start position
    private int x = 100;
    private int y = 100;
    private int dir; //kanske bättre att låta positionerna och direction finnas i Car, mindre kod duplicering

    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final int EAST = 2;
    public static final int WEST = 3;

    public Saab95 (int doors, double engPow, Color color, String modelName, int dir){
        super(doors, engPow, 0, color, modelName);
        this.dir = dir;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }


    //Moves the car in the direction it is currently facing with currentSpeed
    @Override
    public void move() {
        switch (dir) {
            case NORTH -> y -= getCurrentSpeed();
            case SOUTH -> y += getCurrentSpeed();
            case EAST -> x += getCurrentSpeed();
            case WEST -> x -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case NORTH -> dir = WEST;
            case SOUTH -> dir = EAST;
            case EAST -> dir = NORTH;
            case WEST -> dir = SOUTH;
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case NORTH -> dir = EAST;
            case SOUTH -> dir = WEST;
            case EAST -> dir = SOUTH;
            case WEST -> dir = NORTH;
        }
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
