package Model.Cars.Volvo240;

import Model.Base.Car;
import Model.Movements.TrimmedMovable;

import java.awt.*;

public class Volvo240 extends Car {
    public Volvo240(int nrDoors, Color color, String modelName){
        super(nrDoors, color, modelName, new TrimmedMovable(0, 400, 0, 0));
    }
}
