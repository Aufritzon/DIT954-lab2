package application.view;

import java.awt.*;

public class Drawable {
    private final Point point;
    private final String name;


    public Drawable(String name, int x, int y) {
        this.name = name;
        point = new Point(x, y);
    }

    public String getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }
}