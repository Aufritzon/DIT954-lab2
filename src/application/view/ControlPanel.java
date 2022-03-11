package application.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ControlPanel extends JPanel {
    private int gasAmount = 0;
    List<ViewListener> listeners = new ArrayList<>();
    private JSpinner gasSpinner;
    private JLabel gasLabel;
    private JPanel gasPanel;
    private JPanel controlPanel;
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
    }

    private void initComponents() {
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
        gasLabel = new JLabel("Amount of Gas");
        addButton = new JButton("Add vehicle");
        removeButton = new JButton("Remove vehicle");
        controlPanel = new JPanel();
        gasPanel = new JPanel();

        gasSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        controlPanel.setLayout(new GridLayout(2, 7));
        controlPanel.setPreferredSize(new Dimension(width - gasPanel.getPreferredSize().width, height));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(startButton, 3);
        controlPanel.add(addButton, 4);
        controlPanel.add(brakeButton, 5);
        controlPanel.add(turboOffButton, 6);
        controlPanel.add(lowerBedButton, 7);
        controlPanel.add(stopButton, 8);
        controlPanel.add(removeButton,9);

        gasSpinner.addChangeListener(e -> gasAmount = (int)((JSpinner)e.getSource()).getValue());
        turboOnButton.addActionListener(e -> engageListeners(ViewListener::turboOnPerformed));
        turboOffButton.addActionListener(e -> engageListeners(ViewListener::turboOffPerformed));
        liftBedButton.addActionListener(e -> engageListeners(ViewListener::liftBedPerformed));
        lowerBedButton.addActionListener(e -> engageListeners(ViewListener::lowerBedPerformed));
        gasButton.addActionListener(e -> listeners.forEach(l -> l.gasPerformed(gasAmount)));
        brakeButton.addActionListener(e -> listeners.forEach(l -> l.brakePerformed(gasAmount)));
        startButton.addActionListener(e -> engageListeners(ViewListener::startPerformed));
        stopButton.addActionListener(e -> engageListeners(ViewListener::stopPerformed));

        this.add(gasPanel);
        this.add(controlPanel);

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
