package testTrimmedEngine;


import Model.Base.Car;
import Model.Base.CarMovable;
import Model.Base.TrimmedEngine;
import Model.Cars.Saab95;
import Model.Cars.Volvo240;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Model.Base.CarMovable.Direction.NORTH;
import static org.junit.Assert.assertEquals;

public class TestIncrementSpeed {

    private Car volvo;

    @Before
    public void init() {
        volvo = new Volvo240(1, 1, NORTH);
        volvo.engine.startEngine();
    }

    @Test
    public void testIncrementAsExpected() {
        double amount = 0.5;
        double expectedSpeed = Math.min(volvo.engine.getCurrentSpeed() + volvo.engine.speedFactor() * amount,
                                        volvo.engine.getEnginePower());
        volvo.engine.incrementSpeed(amount);
        assertEquals(expectedSpeed, volvo.engine.getCurrentSpeed(), 0.0);
    }
}
