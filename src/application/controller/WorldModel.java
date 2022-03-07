package application.controller;

import application.model.world.DrawableWorld;

public interface WorldModel extends DrawableWorld {

    void moveVehicles();

    void stopVehicles();

    void startVehicles();

    void gasVehicles(int amount);

    void brakeVehicles(int amount);

    void lowerBeds();

    void raiseBeds();

    void turnOnTurbos();

    void turnOffTurbos();

}
