import application.model.vehicles.Car;
import application.model.vehicles.Direction;
import application.model.vehicles.Saab95;
import application.model.vehicles.Transporter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLoadCar {
    private Car saab;
    private Transporter transporter;

    @Before
    public void init() {
        saab = new Saab95(1, 5, Direction.NORTH);
        transporter = new Transporter(1, 2, Direction.NORTH);
        saab.startEngine();
    }

    @Test
    public void testLoadCar() {
        transporter.loadCar(saab);
        assertEquals(transporter.getLoad().getFirst(), saab);
    }
}
