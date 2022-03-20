package application.view;

import application.controller.ViewListener;
import application.model.WorldListener;
import application.model.vehicles.IPositionable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents the full application.application.view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class VehicleView extends JFrame implements WorldListener{
    private static final int X = 800;
    private static final int Y = 800;

    private DrawPanel drawPanel;
    private ControlPanel controlPanel;

    // Constructor
    public VehicleView(String framename) {
        initComponents();
        initFrame(framename);
    }

    // Sets everything in place and fits everything
    private void initComponents() {
        drawPanel = new DrawPanel(X,Y - 240);
        controlPanel = new ControlPanel(X , 240);
        this.add(drawPanel);
        this.add(controlPanel);
    }

    private void initFrame(String title) {
        this.setTitle(title);
        this.getContentPane().setPreferredSize(new Dimension(X ,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        this.pack();

        // Make the frame pack all it's components by respecting the sizes if possible.

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void addControls(JPanel panel) {
        controlPanel.add(panel);
        this.pack();
    }

    public void addControlListener(ViewListener listener) {
        controlPanel.addListener(listener);
    }

    public void removeControlListener(ViewListener listener) {
        controlPanel.removeListener(listener);
    }

    @Override
    public void actOnWorldChange(List<IPositionable> positionables) {
        drawPanel.actOnWorldChange(positionables);
    }
}