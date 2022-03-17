package application.model.vehicles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static application.model.utilities.HelperMethods.RAND;


public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    private static final List<Direction> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();

    public static Direction randomDirection()  {
        return VALUES.get(RAND.nextInt(SIZE));
    }
}
