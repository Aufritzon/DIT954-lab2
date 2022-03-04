package application.view;

import application.model.IPositionable;
import application.model.Position;
import application.model.WorldObserver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;
import java.util.List;

// This panel represent the animated part of the application.application.view with the car images.

public class DrawPanel extends JPanel implements WorldObserver {

    private static final String IMAGE_DIR = "/application/view/pics/";

    BufferedImage saabImage;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;

    private List<? extends IPositionable> positionables;

    private List<String> names;

    private List<Position> positions;


    void moveit(Drawable d, int x, int y){
        d.getPoint().x = x;
        d.getPoint().y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        try {
            saabImage = getImage("Saab95.jpg");
            volvoImage = getImage("Volvo240.jpg");
            scaniaImage = getImage("Scania.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        IPositionable pos;
        if (positionables != null) {
            for (IPositionable positionable : positionables) {
                pos = positionable;
                g.drawImage(pos.getImage(), (int) Math.round(pos.getX()), (int) Math.round(pos.getY()), null);
            }
        }

    }

    private BufferedImage getImageFromDrawable(Drawable drawable) {
        BufferedImage image = null;
        switch (drawable.getName()) {
            case "Volvo240" -> image = volvoImage;
            case "Saab95" -> image = saabImage;
            case "Scania" -> image = scaniaImage;
            default -> {
            }
        }
        return image;
    }

    private BufferedImage getImageFromName(String name) {
        BufferedImage image = null;
        switch (name) {
            case "Volvo240" -> image = volvoImage;
            case "Saab95" -> image = saabImage;
            case "Scania" -> image = scaniaImage;
            default -> {
            }
        }
        return image;
    }

    public BufferedImage getImage(String fileName) throws IOException {
        BufferedImage image;
        InputStream inStream = DrawPanel.class.getResourceAsStream(IMAGE_DIR + fileName);
        if (inStream == null) {
            throw new IllegalArgumentException("Image is missing: " + IMAGE_DIR + fileName);
        }
        image = ImageIO.read(inStream);
        return image;
    }

    @Override
    public void actOnWorld(List<? extends IPositionable> positionables) {
        this.positionables = positionables;
    }
}
