package application.view;

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

    private List<Drawable> drawables;


    private List<String> names;

    private List<Position> positions;


    void moveit(Drawable d, int x, int y){
        d.getPoint().x = x;
        d.getPoint().y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Drawable> drawables) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        this.drawables = drawables;

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
        Position pos;
        for (int i = 0; i < names.size(); i++) {
            pos = positions.get(i);
            BufferedImage image = getImageFromName(names.get(i));
            g.drawImage(image, (int)Math.round(pos.getX()), (int) Math.round(pos.getY()), null);
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

    public List<Drawable> getDrawables() {
        return drawables;
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
    public void actOnWorld(List<String> names, List<Position> positions) {
        this.names = names;
        this.positions = positions;
    }
}
