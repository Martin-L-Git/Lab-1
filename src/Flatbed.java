package src;

public class Flatbed implements iPlatform {

    private boolean isUp;;

    public Flatbed() {
        this.isUp = true;
    }

    public void raisePlatform() {
        isUp = true;
    }

    public void lowerPlatform() {
        isUp = false;
    }

    public boolean isUp() {
        return isUp;
    }

    public boolean isDown() {
        return !isUp;
    }
}