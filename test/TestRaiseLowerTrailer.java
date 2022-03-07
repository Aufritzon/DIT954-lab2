import application.model.Direction;
import application.model.vehicles.Scania;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRaiseLowerTrailer {
    private Scania scania;

    @Before
    public void init() {
        scania = new Scania(1, 5, Direction.NORTH);
    }

    @Test
    public void testRaiseTrailer() {
        int amount = 10;
        scania.raiseTrailer(amount);

        assertEquals(scania.getTrailerAngle(), amount, 0.0);
    }

    @Test
    public void testLowerTrailer() {
        double amount =10;
        scania.raiseTrailer(amount);
        amount = 3;

        scania.lowerTrailer(amount);

        assertEquals(scania.getTrailerAngle(), 7, 0.0);
    }
}

