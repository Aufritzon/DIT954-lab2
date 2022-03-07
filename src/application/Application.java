package application;

import application.controller.CarController;
import application.model.world.World;
import application.view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
    public static void main(String[] args) {

        World world = new World();

        CarView frame = new CarView("CarSim 1.0");

        CarController cc = new CarController(world, frame);

        cc.initController();

        cc.startTimer(50);

    }
}
