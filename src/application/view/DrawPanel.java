package application.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;
import java.util.List;

// This panel represent the animated part of the application.application.view with the car images.

public class DrawPanel extends JPanel{

    private static final String IMAGE_DIR = "/application/view/pics/";

    BufferedImage saabImage;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;

    private final List<Drawable> drawables;

    void moveit(Drawable d, int x, int y){
        d.getPoint().x = x;
        d.getPoint().y = y;
    }

    boolean isInsideDrawPanel(Drawable d, int x, int y) {
        BufferedImage image = getImageFromDrawable(d);
        int maxX = x + image.getWidth();
        int maxY = y + image.getHeight();

        boolean isAbove = y < 0;
        boolean isBelow = maxY > this.getHeight();
        boolean isRightOff = maxX > this.getWidth();
        boolean isLeftOff = x < 0;

        return !(isAbove | isBelow | isRightOff | isLeftOff );
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
        for (Drawable d : drawables) {
            BufferedImage image = getImageFromDrawable(d);
            g.drawImage(image, d.getPoint().x, d.getPoint().y, null);
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
}
