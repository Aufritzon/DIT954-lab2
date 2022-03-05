package application.model;

import java.awt.*;
import java.util.Map;

public interface WorldObservable {
    Iterable<IPositionable> getPositionables();
    void addObserver(WorldObserver observer);
    void removeObserver(WorldObserver observer);
}
