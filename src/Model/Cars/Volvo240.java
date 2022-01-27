package Model.Cars;

import Model.Base.Car;
import Model.Base.TrimmedEngine;
import Model.Base.Direction;

import java.awt.*;

public class Volvo240 extends Car {
    public final static double trimFactor = 1.25;

    public Volvo240(double x, double y, Direction dir, int nrDoors, Color color, String modelName){
        super(x,  y, dir,  nrDoors, color,  modelName, new TrimmedEngine(700, 0, trimFactor));
    }
}
