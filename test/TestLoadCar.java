import application.model.AbstractMovable;
import application.model.Car;
import application.model.Saab95;
import application.model.Transporter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLoadCar {
    private Car saab;
    private Transporter transporter;

    @Before
    public void init() {
        saab = new Saab95(1, 5, AbstractMovable.Direction.NORTH);
        transporter = new Transporter(1, 2, AbstractMovable.Direction.NORTH);
        saab.startEngine();
    }

    @Test
    public void testLoadCar() {
        transporter.loadCar(saab);
        assertEquals(transporter.getLoad().getFirst(), saab);
    }
}
