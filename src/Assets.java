import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Assets {

    private static final String IMAGE_DIR = "pics/";

    private static final Map<Object, BufferedImage> objectImage = new HashMap<>();

    // Bind objects and classes
    // Individual object may be bound else where
    public Assets() {
        bind(Volvo240.class, "Volvo240.jpg");
        bind(Saab95.class, "Saab95.jpg");
        bind(Scania.class, "Scania.jpg");
    }

    // -------------- Methods binding objects/classes to assets -----------------

    // Also possible to bind Class objects to images
    public void bind(Object object, String imageName) {
        BufferedImage i = getImage(imageName);
        if (i != null) {
            objectImage.put(object, i);
        } else {
            throw new IllegalArgumentException("Missing image: " + IMAGE_DIR + imageName);
        }
    }

    // Get image for object
    public BufferedImage get(Object object) {
        BufferedImage image = objectImage.get(object);  // Try to find bound object
        if (image == null) {
            return objectImage.get(object.getClass());  // .. if fail, check if class bound
        }
        return image;
    }

    // ---------- Helpers ------------------------

    private BufferedImage getImage(String fileName) {
        BufferedImage image;
        InputStream inStream = DrawPanel.class.getResourceAsStream(IMAGE_DIR + fileName);
        if (inStream == null) {
            throw new IllegalArgumentException("File is missing: " + IMAGE_DIR + fileName);
        }
        try {
            image = ImageIO.read(inStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("File is missing: " + IMAGE_DIR + fileName);
        }
        return image;
    }
}
