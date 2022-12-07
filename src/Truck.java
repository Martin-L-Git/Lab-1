

import java.awt.*;

public abstract class Truck extends Vehicle {

    protected iPlatform platform;

    public Truck(int nrDoors, Color color, double enginePower, String modelName, iPlatform platform) {
        super(nrDoors, color, enginePower, modelName);
        this.platform = platform;

    }

}
