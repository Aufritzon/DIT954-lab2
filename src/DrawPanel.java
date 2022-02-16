import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    List<DrawVehicle> drawVehicles;



    // Just a single image, TODO: Generalize


    public void moveIt(int x, int y, Vehicle vehicle) {
        Point p = points.get(vehicle);
        p.x = x;
        p.y = y;
    }


    // To keep track of a singel cars position
    Point volvoPoint = new Point();



    private CarController cc;


    private Map<Vehicle,Point> points;


    public void setCc(CarController cc) {
        this.cc = cc;
        this.points = cc.getCarPoints();
    }


// TODO: Make this genereal for all cars

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cc = cc;
        // Print an error message in case file is not found with a try/catch block


    }

    public void setDrawVehicles (List<DrawVehicle> drawVehicles) {
        this.drawVehicles = drawVehicles;

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v : cc.cars) {
            Point p = points.get(v);
            g.drawImage(cc.assets.get(v), (int)v.getX(), (int)v.getY(), null ); // see javadoc for more info on the parameters
        }

    }
}
