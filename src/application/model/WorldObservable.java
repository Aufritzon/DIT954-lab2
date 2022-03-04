package application.model;

import java.awt.*;
import java.util.Map;

public interface WorldObservable {
    Map<Image, Point> getImagePointMap();
    void addObserver(WorldObserver observer);
    void removeObserver(WorldObserver observer);
}
