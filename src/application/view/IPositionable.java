package application.view;

import application.model.Position;

import java.awt.image.BufferedImage;

public interface IPositionable {

    BufferedImage getImage();

    Position getPosition();

    double getX();

    double getY();

}
