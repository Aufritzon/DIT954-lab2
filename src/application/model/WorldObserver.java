package application.model;

import java.util.List;

public interface WorldObserver {
    void actOnWorld(List<String> names, List<Position> positions);
}
