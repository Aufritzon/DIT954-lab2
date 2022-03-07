import application.model.Direction;
import application.model.vehicles.Saab95;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Tests for the turnRight() method in CarMovable
 */

public class TestTurnRight {

    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, Direction.NORTH);
        saab.startEngine();
        saab.setTurboOn();
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
