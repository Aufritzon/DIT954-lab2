package Model.Base;

public class Turbo {

    private boolean turboOn;

    public Turbo(boolean turboOn) {
        this.turboOn = turboOn;

    }

    public boolean getTurboOn() {
        return turboOn;
    }

    public void setTurbo(boolean turboOn) {
            this.turboOn = turboOn;
    }

    public void setTurboOn(){
            turboOn = true;
    }

    public void setTurboOff(){
            turboOn = false;
    }


}
