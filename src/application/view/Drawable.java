package application.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Drawable {
    private static final String IMAGE_DIR = "/application/view/pics/";

    private Point point;
    private String name;
    private BufferedImage image;

    public Drawable(String name, Point point) {
        this.name = name;
        this.point = point;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(IMAGE_DIR + name + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public BufferedImage getImage() {
        return image;
    }


}