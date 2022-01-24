package Model.Base;

import java.awt.*;

public abstract class Car {

    private final int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private CarMovable movable;

    public Car (int nrDoors, Color color, String modelName, CarMovable movable){
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.movable = movable;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }
}
