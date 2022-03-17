package application.view;

import application.controller.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ControlPanel extends JPanel {

    private final List<ViewListener> listeners = new ArrayList<>();
    private int gasAmount = 0;
    private JSpinner gasSpinner;
    private JButton gasButton;
    private JButton brakeButton;
    private JButton turboOnButton;
    private JButton turboOffButton;
    private JButton liftBedButton;
    private JButton lowerBedButton;
    private JButton startButton;
    private JButton stopButton;
    private JButton addButton;
    private JButton removeButton;
    private final int width;
    private final int height;

    public ControlPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        initComponents();
        addActionListeners();
    }

    private void initComponents() {
        JPanel buttonPanel = new JPanel();
        JPanel gasPanel = new JPanel();
        gasButton = new JButton("Gas");
        brakeButton = new JButton("Brake");
        turboOnButton = new JButton("Saab Turbo on");
        turboOffButton = new JButton("Saab Turbo off");
        liftBedButton = new JButton("Scania Lift Bed");
        lowerBedButton = new JButton("Lower Lift Bed");
        startButton = new JButton("Start Engine");
        startButton.setBackground(Color.GREEN);

        stopButton = new JButton("Stop Engine");
        stopButton.setBackground(Color.RED);
        gasSpinner = new JSpinner();
        addButton = new JButton("Add vehicle");
        removeButton = new JButton("Remove vehicle");

        gasSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(new JLabel("Amount of Gas"), BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        buttonPanel.setLayout(new GridLayout(2, 7));
        buttonPanel.setPreferredSize(new Dimension(width - gasPanel.getPreferredSize().width, height));
        buttonPanel.add(gasButton, 0);
        buttonPanel.add(turboOnButton, 1);
        buttonPanel.add(liftBedButton, 2);
        buttonPanel.add(startButton, 3);
        buttonPanel.add(addButton, 4);
        buttonPanel.add(brakeButton, 5);
        buttonPanel.add(turboOffButton, 6);
        buttonPanel.add(lowerBedButton, 7);
        buttonPanel.add(stopButton, 8);
        buttonPanel.add(removeButton,9);

        this.add(gasPanel);
        this.add(buttonPanel);
    }

    private void addActionListeners() {
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());
        turboOnButton.addActionListener(e -> engageListeners(ViewListener::turboOnPerformed));
        turboOffButton.addActionListener(e -> engageListeners(ViewListener::turboOffPerformed));
        liftBedButton.addActionListener(e -> engageListeners(ViewListener::liftBedPerformed));
        lowerBedButton.addActionListener(e -> engageListeners(ViewListener::lowerBedPerformed));
        startButton.addActionListener(e -> engageListeners(ViewListener::startPerformed));
        stopButton.addActionListener(e -> engageListeners(ViewListener::stopPerformed));
        addButton.addActionListener(e -> engageListeners(ViewListener::addVehiclePerformed));
        removeButton.addActionListener(e -> engageListeners(ViewListener::removeVehiclePerformed));
        gasButton.addActionListener(e -> listeners.forEach(l -> l.gasPerformed(gasAmount)));
        brakeButton.addActionListener(e -> listeners.forEach(l -> l.brakePerformed(gasAmount)));
    }

    private void engageListeners(Consumer<ViewListener> consumer) {
        listeners.forEach(consumer);
    }

    public void addListener(ViewListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ViewListener listener) {
        listeners.remove(listener);
    }

}
