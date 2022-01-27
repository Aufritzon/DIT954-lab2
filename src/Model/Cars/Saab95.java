package Model.Cars;

import Model.Base.*;
import java.awt.*;

public class Saab95 extends Car{
    public Saab95 (int nrDoors, Color color, String modelName) {
        super(0, 0, Direction.NORTH,nrDoors, color, modelName, new TurboEngine(700,0,false));
    }
}

