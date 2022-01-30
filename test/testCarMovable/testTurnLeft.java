package testCarMovable;

import Model.Base.Car;
import Model.Base.CarMovable;
import Model.Cars.Saab95;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static Model.Base.CarMovable.Direction.NORTH;

/**
 * Tests for the turnLeft() method in CarMovable
 */
public class testTurnLeft {

    private Car saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, NORTH);
        saab.engine.startEngine();
    }

    @Test
    public void testFullRotation() {
        CarMovable.Direction d1 = saab.getDir();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(saab.getDir(), d1);
    }
}


