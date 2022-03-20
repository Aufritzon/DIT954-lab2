package application.controller;

public interface ViewListener {

    void gasPerformed(int gasAmount);

    void brakePerformed(int gasAmount);

    void turboOnPerformed();

    void turboOffPerformed();

    void startPerformed();

    void stopPerformed();

    void liftBedPerformed();

    void lowerBedPerformed();

}
