package application.view;


import application.model.IPositionable;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// This panel represent the animated part of the application.application.view with the car images.

public class DrawPanel extends JPanel {

    private Iterable<IPositionable> positionables;

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
            for (IPositionable p : positionables) {
                g.drawImage(p.getImage() , (int) p.getX(), (int) p.getY(), null);
        }
    }

    public void setPositionables(Iterable<IPositionable> positionables) {
        this.positionables = positionables;
    }
}
