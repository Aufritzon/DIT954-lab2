package application.view;

import java.awt.*;


public class Drawable {
    private final Point point;
    private final String name;

    public Drawable(String name, Point point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }
}