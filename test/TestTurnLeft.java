import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

<<<<<<< HEAD:test/testCarMovable/testTurnLeft.java
/**
 * Tests for the turnLeft() method in CarMovable
 */
public class testTurnLeft {
=======
public class TestTurnLeft {
>>>>>>> new:test/TestTurnLeft.java

    private Car saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, AbstractMovable.Direction.NORTH);
        saab.startEngine();
    }

    @Test
    public void testFullRotation() {
        AbstractMovable.Direction d1 = saab.getDir();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(saab.getDir(), d1);
    }
}


