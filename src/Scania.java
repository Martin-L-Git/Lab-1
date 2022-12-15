

import java.awt.*;

public class Scania extends Truck {

    public Scania() {
        super(2, Color.green, 200, "Sopis2000", 0, 0, new Ramp(70, 10));
    }

    public void lowerPlatform() {
        platform.lowerPlatform();
    }

    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            platform.raisePlatform();
        }
    }

    @Override
    public double speedFactor() {
        if (platform.isDown()) {
            return getEnginePower() * 0.01;
        } else {
            return 0.0;
        }
    }

    public iPlatform getPlatform() {
        return platform;
    }

}
