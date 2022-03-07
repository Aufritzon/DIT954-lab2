import application.model.vehicles.Car;
import application.model.Direction;
import application.model.vehicles.Saab95;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the move() method in CarMovable
 */
public class TestMove {

    private Car saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, Direction.NORTH);
        saab.startEngine();
    }

    @Test
    public void testMoveCarNorth() {
        saab.move();
        assertEquals(0.9, saab.getY(), 0.0);
    }

    @Test
    public void testMoveCarForthAndBack() {
        saab.move();
        saab.setCurrentSpeed(-saab.getCurrentSpeed());
        saab.move();
        assertEquals(1, saab.getY(), 0.0);
    }


}
