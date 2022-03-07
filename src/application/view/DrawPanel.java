package application.view;

import application.model.Drawable;
import application.model.world.DrawableWorld;

import java.awt.*;
import javax.swing.*;

// This panel represent the animated part of the application.application.view with the car images.

public class DrawPanel extends JPanel {
    private DrawableWorld DrawableWorld;

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
        if(DrawableWorld != null) {
            for (Drawable d : DrawableWorld.getDrawables()) {
                g.drawImage(d.getImage(), (int) d.getX(), (int) d.getY(), null);
            }
        }
    }

    public void updateDrawableWorld(DrawableWorld DrawableWorld) {
        this.DrawableWorld = DrawableWorld;
    }

}
