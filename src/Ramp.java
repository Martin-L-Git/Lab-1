

public class Ramp implements iPlatform {

    private int deltaAngle; // Angle incrementation
    private int currentAngle = 0; // Default angle
    private int maxAngle; // Maximum angle

    public Ramp(int maxAngle, int deltaAngle) {
        this.maxAngle = maxAngle;
        this.deltaAngle = deltaAngle;
        this.currentAngle = 0;
    }

    public boolean isUp() {
        return currentAngle > 0;
    }

    public boolean isDown() {
        return currentAngle == 0;
    }

    public int getCurrentAngle() { // getter
        return currentAngle;
    }

    public void raisePlatform() {
        currentAngle += deltaAngle;
        if (currentAngle + deltaAngle > maxAngle) {
            currentAngle = maxAngle;
        }
    }

    public void lowerPlatform() {
        currentAngle -= deltaAngle;
        if (currentAngle - deltaAngle < 0) {
            currentAngle = 0;
        }
    }
}
