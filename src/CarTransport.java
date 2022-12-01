package src;

import java.awt.*;
import java.util.*;

public class CarTransport extends Truck implements iCanStoreCars {

    private ArrayList<Car> loadedCars;
    private double reasonableDistance = 2;
    private int maxCapacity = 6;

    public CarTransport() {
        super(2, Color.yellow, 300, "GamlaBettan", new Flatbed());
        this.loadedCars = new ArrayList<Car>();
    }

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            platform.lowerPlatform();
        }
    }

    public void raisePlatform() {
        platform.raisePlatform();
    }

    public void loadCar(Car car) {
        double x1 = getPosition().getX();
        double x2 = car.getPosition().getX();
        double y1 = getPosition().getY();
        double y2 = car.getPosition().getY();
        if (getPosition().calculateDistance(x1, x2, y1, y2) <= reasonableDistance 
        && platform.isUp() == false && loadedCars.size() < maxCapacity) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (platform.isDown()) {
            loadedCars.remove(car);
        }
    }

    public iPlatform getPlatform() {
        return platform;
    }

    @Override
    public double speedFactor() {
        if (platform.isUp()) {
            return getEnginePower() * 0.01;
        } else {
            return 0.0;
        }
    }
}
