import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    List<DrawVehicle> drawVehicles;

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;




    // To keep track of a singel cars position
    Point volvoPoint = new Point();



    // TODO: Make this genereal for all cars

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void setDrawVehicles (List<DrawVehicle> drawVehicles) {
        this.drawVehicles = drawVehicles;

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    protected void paintComponent(Graphics g, List<Vehicle> vehicles) {
        super.paintComponent(g);
        for(Vehicle v : vehicles) {
            g.drawImage(vehicleImage(v), (int)Math.round(v.getX()), (int)Math.round(v.getY()), null ); // see javadoc for more info on the parameters
        }
    }

    private BufferedImage vehicleImage(Vehicle v) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + v.getClass().getName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
