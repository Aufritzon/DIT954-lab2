import application.model.vehicles.Car;
import application.model.vehicles.Direction;
import application.model.vehicles.Saab95;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the turnLeft() method in CarMovable
 */

public class TestTurnLeft {

    private Car saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, Direction.NORTH);
        saab.startEngine();
    }

    @Test
    public void testFullRotation() {
        Direction d1 = saab.getDir();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(saab.getDir(), d1);
    }
}


