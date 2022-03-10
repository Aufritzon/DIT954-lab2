import application.model.vehicles.Car;
import application.model.vehicles.Direction;
import application.model.vehicles.Volvo240;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIncrementSpeed {

    private Car volvo;

    @Before
    public void init() {
        volvo = new Volvo240(1, 1, Direction.NORTH);
        volvo.startEngine();
    }

    @Test
    public void testIncrementAsExpected() {
        double amount = 0.5;
        double expectedSpeed = Math.min(volvo.getCurrentSpeed() + volvo.speedFactor() * amount,
                                        volvo.getEnginePower());
        volvo.incrementSpeed(amount);
        assertEquals(expectedSpeed, volvo.getCurrentSpeed(), 0.0);
    }
}
