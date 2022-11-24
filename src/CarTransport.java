package src;
import java.awt.*;
import java.util.ArrayList;
import java.lang.Math.*;


public class CarTransport extends Car{
    
    private Flatbed platform;
    private ArrayList<Car> loadedCars;
    
    public CarTransport(){
        super(2, Color.yellow, 300, "TransportimusMaximus", 0, 0, Direction.UP);
        this.platform = new Flatbed();
        this.loadedCars = new ArrayList<Car>(6);
    }
    
    public void lowerPlatform(){
        if (currentSpeed == 0) {
            platform.lowerPlatform();
        }
        
    }
    public void raisePlatform() {
        platform.raisePlatform();
    }


    // #2 == close enough to load
    public void loadCar(Car otherCar){
        if (Math.sqrt(Math.pow((this.getX() - otherCar.getX()), 2) + (Math.pow((this.getY() - otherCar.getY()), 2))) <= 2 
            && platform.isUp() == false){
            loadedCars.add(otherCar);
        }      
    }

    public void unloadCar(Car otherCar){
        if (platform.isUp() == false){
            loadedCars.remove(otherCar); // megaproblem for Max
        }
    }

    @Override
    public double speedFactor(){
        if (platform.isUp() == true){
            return getEnginePower() * 0.01;
        }
        else {return 0.0;}
    }
    

}
