package application.model.world;

import application.view.IPositionable;

import java.util.List;

public interface WorldListener {
    void actOnWorldChange(List<IPositionable> positionables);
}
