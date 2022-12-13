
import java.util.*;

public class CarRepairShop {

    private Position position;
    private CarStorage carStorage;

    public CarRepairShop(double x, double y, int maxCapacity) {
        this.position = new Position(x, y);
        this.carStorage = new CarStorage(position, maxCapacity);
    }

    public void loadCar(Car car) {
        carStorage.loadCar(car);
    }

    public void unloadCar(Car car) {
        carStorage.unloadCar(car);
    }

    public int getLoadedCarsSize() {
        return carStorage.getLoadedCarsSize();
    }

    public int getMaxCapacity() {
        return carStorage.getMaxCapacity();
    }

    public Position getPosition() {
        return position;
    }

    public double getReasonableDistance() {
        return carStorage.getReasonableDistance();
    }

}
