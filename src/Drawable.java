import java.awt.*;

public class Drawable {
    private Point point;
    private String modelName;


    public Drawable (String modelName, int x, int y) {
        this.modelName = modelName;
        point = new Point(x, y);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}