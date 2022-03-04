package application.view;

import java.awt.*;
import javax.swing.*;
import java.util.Map;

// This panel represent the animated part of the application.application.view with the car images.

public class DrawPanel extends JPanel {

    private Map<Image,Point> imagePointMap;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Point p;
            for (Image i : imagePointMap.keySet()) {
                p = imagePointMap.get(i);
                g.drawImage(i, p.x, p.y, null);
            }
    }

    public void setImagePointMap(Map<Image,Point> imagePointMap) {
        this.imagePointMap = imagePointMap;
    }
}
