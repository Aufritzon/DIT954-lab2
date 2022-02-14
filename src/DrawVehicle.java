import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DrawVehicle {
    BufferedImage image;
    Point point;
    Vehicle vehicle;

    public DrawVehicle (Vehicle vehicle) {
        this.vehicle = vehicle;
        point = new Point((int)Math.round(vehicle.getX()),(int)Math.round(vehicle.getY()));
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getClass().getName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
