import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

<<<<<<< HEAD:test/testCarMovable/testTurnRight.java
/**
 * Tests for the turnRight() method in CarMovable
 */
public class testTurnRight {
=======
public class TestTurnRight {
>>>>>>> new:test/TestTurnRight.java

    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95(1, 1, AbstractMovable.Direction.NORTH);
        saab.startEngine();
        saab.setTurboOn();
    }

    @Test
    public void testFullRotation() {
        AbstractMovable.Direction d1 = saab.getDir();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertEquals(saab.getDir(), d1);
    }
}
