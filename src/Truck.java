

import java.awt.*;

public abstract class Truck extends Vehicle {

    protected iPlatform platform;

    public Truck(int nrDoors, Color color, double enginePower, String modelName, int x, int y, iPlatform platform) {
        super(nrDoors, color, enginePower, modelName, x, y);
        this.platform = platform;

    }

}
