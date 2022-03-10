package application.view;

import application.model.world.WorldListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * This class represents the full application.application.view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class VehicleView extends JFrame implements WorldListener {
    private static final int X = 800;
    private static final int Y = 800;

    DrawPanel drawPanel;
    ControlPanel controlPanel;
    GasPanel gasPanel;
    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    AddRemovePanel addRemovePanel;

    List<ViewListener> listeners = new ArrayList<>();

    // Constructor
    public VehicleView(String framename) {
        initComponents();
        initFrame(framename);
    }

    // Sets everything in place and fits everything
    private void initComponents() {
        initDrawPanel();
        initGasPanel();
        initControlPanel();
        initStartButton();
        initStopButton();

    }

    private void initFrame(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
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

    private void initStartButton() {
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        startButton.addActionListener(e -> engageListeners(ViewListener::startPerformed));

        this.add(startButton);
    }

    private void initStopButton() {
        stopButton.addActionListener(e -> engageListeners(ViewListener::stopPerformed));
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);
    }

    private void initControlPanel() {
        controlPanel = new ControlPanel((X / 2) + 4, 200);
        controlPanel.turboOnButton.addActionListener(e -> engageListeners(ViewListener::turboOnPerformed));
        controlPanel.turboOffButton.addActionListener(e -> engageListeners(ViewListener::turboOffPerformed));
        controlPanel.liftBedButton.addActionListener(e -> engageListeners(ViewListener::liftBedPerformed));
        controlPanel.lowerBedButton.addActionListener(e -> engageListeners(ViewListener::lowerBedPerformed));
        controlPanel.gasButton.addActionListener(e -> listeners.forEach(l -> l.gasPerformed(gasPanel.getGasAmount())));
        controlPanel.brakeButton.addActionListener(e -> listeners.forEach(l -> l.brakePerformed(gasPanel.getGasAmount())));
        this.add(controlPanel);
    }

    private void initGasPanel() {
        gasPanel = new GasPanel();
        this.add(gasPanel);
    }

    private void initDrawPanel() {
        drawPanel = new DrawPanel(X, Y - 240);
        this.add(drawPanel);
    }



    private void initRemoveButton() {

    }

    private void engageListeners(Consumer<ViewListener> consumer) {
        listeners.forEach(consumer);
    }

    @Override
    public void actOnWorldChange(List<IPositionable> positionables) {
        drawPanel.actOnWorldChange(positionables);
    }

    public void addListener(ViewListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ViewListener listener) {
        listeners.remove(listener);
    }
}