package src;

import java.awt.*;

public class Volvo240 extends Car implements Movable{

    public final static double trimFactor = 1.25;

    //random start position
    private int x = 150;
    private int y = 150;
    private int dir; //kanske bättre att låta positionerna och direction finnas i Car, mindre kod duplicering

    //direction represented by integers
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final int EAST = 2;
    public static final int WEST = 3;


    public Volvo240(int nrDoors, double enginePower, Color color, String modelName, int dir){
        super(nrDoors, enginePower, 0, color, modelName);
        this.dir = dir;
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
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
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
