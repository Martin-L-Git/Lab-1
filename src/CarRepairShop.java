package src;

import java.util.*;

/*
    Create a representation of a car repair shop. The following aspects must be addressed:

    * A workshop must be able to receive ("load"?) a number of cars, up to a maximum number that can vary between different workshops
    * Cars can only be loaded if they are reasonably close to the workshop.
    * When a car is unloaded, it should then end up reasonably close to the workshop.

    Try to make it so that there is no duplication between the code for the Scania trucks, car transports and car workshops.

*/


public class CarRepairShop implements iCanStoreCars{

    private ArrayList<Car> repairFloorCars;
    private double reasonableDistance = 2;
    private int maxCapacity = 12;
    private Position position;

    public CarRepairShop() {
        this.position = new Position(0, 0);
        this.repairFloorCars = new ArrayList<Car>();
    }

    public void loadCar(Car other){
        double x1 = position.getX();
        double x2 = other.getPosition().getX();
        double y1 = position.getY();
        double y2 = other.getPosition().getY();
        if (position.calculateDistance(x1, x2, y1, y2) <= reasonableDistance && repairFloorCars.size() < maxCapacity){
            repairFloorCars.add(other);
        }      
    }

    public void unloadCar(Car car){
        double x = position.getX();
        double y = position.getY();
        repairFloorCars.remove(car);
       
        }
}

    


