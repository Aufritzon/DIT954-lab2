package application.model.world;

import application.model.vehicles.Direction;
import application.model.vehicles.IVehicle;
import application.model.vehicles.TrailerVehicle;
import application.model.vehicles.TurboVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Vehicles {
    VehicleFactory vehicleFactory = new VehicleFactory();

    List<TurboVehicle> turboVehicles = new ArrayList<>();
    List<TrailerVehicle> trailerVehicles = new ArrayList<>();
    List<IVehicle> vehicles = new ArrayList<>();


    public void addTurboVehicle(TurboVehicle vehicle) {
        turboVehicles.add(vehicle);
        vehicles.add(vehicle);
    }

    public void addTrailerVehicle(TrailerVehicle vehicle) {
        trailerVehicles.add(vehicle);
        vehicles.add(vehicle);
    }

    public void addVehicle(IVehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<TurboVehicle> getTurboVehicles() {
        return turboVehicles;
    }

    public List<TrailerVehicle> getTrailerVehicles() {
        return trailerVehicles;
    }

    public List<IVehicle> getVehicles() {
        return vehicles;
    }

}
