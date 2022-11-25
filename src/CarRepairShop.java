package src;

import java.util.*;

public class CarRepairShop implements iCanStoreCars {

    private ArrayList<Car> repairFloorCars;
    private double reasonableDistance = 2;
    private int maxCapacity = 12;
    private Position position;

    public CarRepairShop(double x, double y) {
        this.position = new Position(x, y);
        this.repairFloorCars = new ArrayList<Car>();
    }

    public void loadCar(Car other) {
        double x1 = position.getX();
        double x2 = other.getPosition().getX();
        double y1 = position.getY();
        double y2 = other.getPosition().getY();
        if (position.calculateDistance(x1, x2, y1, y2) <= reasonableDistance && repairFloorCars.size() < maxCapacity) {
            repairFloorCars.add(other);
        }
    }

    public void unloadCar(Car car) {
        double x = position.getX();
        double y = position.getY();
        repairFloorCars.remove(car);

    }
}
