package src;
import java.awt.*;
import java.util.ArrayList;
import java.math.*;


public class CarTransport extends Car{
    
    private Flatbed platform;
    private ArrayList<Car> loadedCars;
    private double reasonableDistance = 2;
    
    public CarTransport(){
        super(2, Color.yellow, 300, "TransportimusMaximus");
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

    public void loadCar(Car otherCar){
        if (Math.sqrt(Math.pow((this.getX() - otherCar.getX()), 2) + (Math.pow((this.getY() - otherCar.getY()), 2))) <= reasonableDistance 
            && platform.isUp() == false){
            loadedCars.add(otherCar);
        }      
    }

    public void unloadCar(Car otherCar){
        if (platform.isUp() == false){
            loadedCars.remove(otherCar); 
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
