package testTrimmedEngine;


import Model.Base.Car;
import Model.Cars.Volvo240;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static Model.Base.CarMovable.Direction.NORTH;

public class TestDecrementSpeed {

    private Car volvo;

    @Before
    public void init() {
        volvo = new Volvo240(1, 1, NORTH);
        volvo.engine.startEngine();
    }

    @Test
    public void testDecrementAsExpected() {
        double expectedSpeed = (Math.max(volvo.engine.getCurrentSpeed() - volvo.engine.speedFactor() * 1, 0));
        volvo.engine.decrementSpeed(1);
        assertEquals(expectedSpeed, volvo.engine.getCurrentSpeed(), 0.0);
    }
}
