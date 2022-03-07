import application.model.Direction;
import application.model.vehicles.Saab95;
import application.model.workshops.Workshop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStoreCar {
    private Saab95 saab;
    private Workshop<Saab95> workshop;

    @Before
    public void init() {
        saab = new Saab95(1, 5, Direction.NORTH);
        workshop= new Workshop<>(10);
    }

    @Test
    public void testStoreCar() {
        workshop.storeCar(saab);

        Saab95 f = workshop.retrieveCar();
        assertEquals(f, saab);
    }
}
