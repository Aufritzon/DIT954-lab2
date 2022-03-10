package application.view;

import javax.swing.*;
import java.awt.*;

public class GasPanel extends JPanel {
    JSpinner gasSpinner;
    JLabel gasLabel = new JLabel("Amount of gas");
    private int gasAmount;

    public GasPanel() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());
        this.setLayout(new BorderLayout());
        this.add(gasLabel, BorderLayout.PAGE_START);
        this.add(gasSpinner, BorderLayout.PAGE_END);
    }

    public int getGasAmount() {
        return gasAmount;
    }

}