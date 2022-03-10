package application.view;

import application.model.world.WorldListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// This panel represent the animated part of the application.application.view with the car images.

public class DrawPanel extends JPanel {

    private List<IPositionable> positionables = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IPositionable p : positionables) {
            g.drawImage(p.getImage(), (int) p.getX(), (int) p.getY(), null);

        }
    }

    public void actOnWorldChange(List<IPositionable> positionables) {
        this.positionables = positionables;
        this.repaint();
    }
}
