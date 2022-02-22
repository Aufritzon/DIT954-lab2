import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;
import java.nio.BufferOverflowException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private static final String IMAGE_DIR = "pics/";

    BufferedImage saabImage;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;

    // TODO: Make this genereal for all cars
    void moveit(Drawable d, int x, int y){
        d.getPoint().x = x;
        d.getPoint().y = y;
    }

    Point getDrawablePoint(Drawable drawable) {
        return drawable.getPoint();
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

    private List<Drawable> drawables;

    // Just a single image, TODO: Generalize


// TODO: Make this genereal for all cars

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Drawable> drawables) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        this.drawables = drawables;
        // Print an error message in case file is not found with a try/catch block
        saabImage = getImage("Saab95.jpg");
        volvoImage = getImage("Volvo240.jpg");
        scaniaImage = getImage("Scania.jpg");
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
        switch (drawable.getModelName()) {
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

    public BufferedImage getImage(String fileName) {
        BufferedImage image;
        InputStream inStream = DrawPanel.class.getResourceAsStream(IMAGE_DIR + fileName);
        if (inStream == null) {
            throw new IllegalArgumentException("Image is missing: " + IMAGE_DIR + fileName);
        }
        try {
            image = ImageIO.read(inStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("Image is missing: " + IMAGE_DIR + fileName);
        }
        return image;
    }
}
