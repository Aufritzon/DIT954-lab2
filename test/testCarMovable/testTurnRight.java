package testCarMovable;

import Model.Base.Car;
import Model.Cars.Saab95;
import Model.Base.CarMovable.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static Model.Base.CarMovable.Direction.NORTH;

/**
 * Tests for the turnRight() method in CarMovable
 */
public class testTurnRight {

    private Car saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, NORTH);
        saab.engine.startEngine();
    }

    @Test
    public void testFullRotation() {
        Direction d1 = saab.getDir();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(saab.getDir(), d1);
    }
}
