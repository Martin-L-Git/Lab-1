package src;

import java.util.ArrayList;

public class CarStorage implements iCanStoreCars {

    private ArrayList<Car> loadedCars;
    private Position position;
    private double reasonableDistance;
    private int maxCapacity;

    public CarStorage(Position position, int maxCapacity) {
        this.loadedCars = new ArrayList<Car>();
        this.position = position;
        this.reasonableDistance = 2;
        this.maxCapacity = maxCapacity;
    }

    public void loadCar(Car car) {
        double x1 = position.getX();
        double x2 = car.getPosition().getX();
        double y1 = position.getY();
        double y2 = car.getPosition().getY();
        if (position.calculateDistance(x1, x2, y1, y2) <= reasonableDistance && loadedCars.size() < maxCapacity) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        loadedCars.remove(car);
        double carPlacementX = position.getX() + reasonableDistance;
        double carPlacementY = position.getY() + reasonableDistance;
        car.getPosition().setX(carPlacementX);
        car.getPosition().setY(carPlacementY);

    }

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }

    public double getReasonableDistance() {
        return reasonableDistance;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}