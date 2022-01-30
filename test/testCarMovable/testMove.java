package testCarMovable;

import Model.Base.Car;
import Model.Cars.Saab95;
import org.junit.Before;
import org.junit.Test;

import static Model.Base.CarMovable.Direction.NORTH;
import static org.junit.Assert.assertEquals;


/**
 * Tests for the move() method in CarMovable
 */
public class testMove {

    private Car saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, NORTH);
        saab.engine.startEngine();
    }

    @Test
    public void testMoveCarNorth() {
        saab.move();
        assertEquals(0.9, saab.getY(), 0.0);
    }

    @Test
    public void testMoveCarForthAndBack() {
        saab.move();
        saab.engine.setCurrentSpeed(-saab.engine.getCurrentSpeed());
        saab.move();
        assertEquals(1, saab.getY(), 0.0);
    }


}
