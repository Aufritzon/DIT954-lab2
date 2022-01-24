package Model.Cars.Saab95;

import Model.Base.Car;
import Model.Base.CarMovable;
import Model.Movements.TrimmedMovable;
import Model.Movements.TurboMovable;

import java.awt.*;

public class Saab95 extends Car {
    public Saab95 (int nrDoors, Color color, String modelName){
        super(nrDoors, color, modelName, new TurboMovable(0, 700, 0, 0, CarMovable.Direction.WEST));
    }
}

