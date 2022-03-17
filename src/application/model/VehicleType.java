package application.model;

import application.model.utilities.HelperMethods;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum VehicleType {
    SAAB95,
    VOLVO240,
    SCANIA,
    ;

    private static final List<VehicleType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    public static VehicleType randomVehicleType()  {
        return VALUES.get(HelperMethods.RAND.nextInt(SIZE));
    }
}
