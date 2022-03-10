package application.model.world;

import application.model.vehicles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleFactory {
    private static final Random rand = new Random();
    List<String> modelNames = List.of("Saab95","Volvo240","Scania");
    public IVehicle createVehicle(String modelName, int x, int y, Direction dir) {

        if (modelName == null || modelName.isEmpty()) {
            return null;
        }
        if ("Saab95".equals(modelName)) {
            return new Saab95(x, y, dir);
        }
        if ("Volvo240".equals(modelName)) {
            return new Volvo240(x, y, dir);
        }
        if ("Scania".equals(modelName)) {
            return new Scania(x, y, dir);
        }
        return null;
    }

    public IVehicle createRandomVehicle(int x, int y, Direction dir) {
        String randomName = modelNames.get(rand.nextInt(modelNames.size()));
        return createVehicle(randomName ,3,3,Direction.NORTH);
    }
}
