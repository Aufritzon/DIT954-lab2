package application.model.world;

import application.model.vehicles.IVehicle;
import application.model.vehicles.TrailerVehicle;
import application.model.vehicles.TurboVehicle;

import java.util.*;

public class Vehicles {
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
        return Collections.unmodifiableList(turboVehicles);
    }

    public List<TrailerVehicle> getTrailerVehicles() {
        return Collections.unmodifiableList(trailerVehicles);
    }

    public List<IVehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }
}
