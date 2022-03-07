import application.model.vehicles.Car;
import application.model.Direction;
import application.model.vehicles.Volvo240;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDecrementSpeed {

    private Car volvo;

    @Before
    public void init() {
        volvo = new Volvo240(1, 1, Direction.NORTH);
        volvo.startEngine();
    }

    @Test
    public void testDecrementAsExpected() {
        double expectedSpeed = (Math.max(volvo.getCurrentSpeed() - volvo.speedFactor() * 1, 0));
        volvo.decrementSpeed(1);
        assertEquals(expectedSpeed, volvo.getCurrentSpeed(), 0.0);
    }
}
