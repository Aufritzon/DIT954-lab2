package application.model;

import application.model.vehicles.IPositionable;

import java.util.List;

public interface WorldListener {
    void actOnWorldChange(List<IPositionable> positionables);
}
