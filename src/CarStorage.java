
import java.util.ArrayList;

public class CarStorage {

    private ArrayList<Car> loadedCars;
    private Position position;
    private double reasonableDistance;
    private int maxCapacity;
    
    // All commented in this class is another solution for ensuring that we cannot add() more cars than we are allowed to by using a getter of loadedCars.
    // Ignore for now, we solved the critical issue by simply removing the getter and implementing a new method that only return the current size of the loadedCars.

    // private Car [] loadedCars2;

    public CarStorage(Position position, int maxCapacity) {
        this.loadedCars = new ArrayList<Car>();
        this.position = position;
        this.reasonableDistance = 2;
        this.maxCapacity = maxCapacity;

        // this.loadedCars2 = new Car [maxCapacity];
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

    /*

    public void loadCar2 (Car car) {
        for (int i = 0; i < loadedCars2.length; i++){
            if (loadedCars2[i] == null){
                loadedCars2[i] = car;
            }
        }
    }

    */

    public void unloadCar(Car car) {
        loadedCars.remove(car);
        double carPlacementX = position.getX() + reasonableDistance;
        double carPlacementY = position.getY() + reasonableDistance;
        car.getPosition().setX(carPlacementX);
        car.getPosition().setY(carPlacementY);

    }

    public int getLoadedCarsSize() {
        return loadedCars.size();
    }

    public double getReasonableDistance() {
        return reasonableDistance;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}