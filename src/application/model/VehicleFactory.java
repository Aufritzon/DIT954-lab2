package application.model;

import application.model.vehicles.*;

import static application.model.utilities.HelperMethods.RAND;

public class VehicleFactory {
    public static IVehicle createVehicle(VehicleType type, int x, int y, Direction dir) {
        IVehicle vehicle = null;
        switch (type) {
            case SAAB95 -> vehicle = new Saab95(x, y, dir);
            case VOLVO240 -> vehicle = new Volvo240(x, y, dir);
            case SCANIA -> vehicle = new Scania(x, y, dir);
        }
        return vehicle;
    }

    public static IVehicle createVehicle() {
        return createVehicle(
                VehicleType.randomVehicleType(),
                RAND.nextInt(0, World.WIDTH - 100),
                RAND.nextInt(0, World.HEIGHT - 100),
                Direction.randomDirection()
        );
    }

}
