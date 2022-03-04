package application.model;

import java.awt.image.BufferedImage;

public interface IPositionable {
    Position getPosition();
    double getX();
    double getY();
    BufferedImage getImage();
}
