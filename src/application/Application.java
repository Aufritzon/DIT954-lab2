package application;

import application.controller.MovementController;
import application.controller.VehicleController;
import application.model.World;
import application.model.vehicles.AddVehicleController;
import application.view.VehicleView;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {

        World world = new World();

        VehicleView frame = new VehicleView("VehicleSim 1.0");

        MovementController mc = new MovementController(world);

        VehicleController vc = new VehicleController(world);

        AddVehicleController vac = new AddVehicleController(world);

        frame.addControls(vac.getAddRemovePanel());

        world.addListener(frame);

        frame.addControlListener(vc);

        new Timer(50, mc).start();
    }
}
