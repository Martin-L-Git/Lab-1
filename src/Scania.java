package src;
import java.awt.*;

public class Scania extends Car {
    
    private Ramp platform;

    public Scania(Ramp platform) {
        super(2, Color.green, 200, "Sopis2000");
        this.platform = new Ramp(70, 10);
    }

    public void lowerPlatform(){
        platform.lowerPlatform();
    }

    public void raisePlatform(){
        if (currentSpeed == 0){
            platform.raisePlatform();
        }
    }

    @Override
    public double speedFactor(){
        if (platform.getCurrentAngle() == 0){
            return getEnginePower() * 0.01;
        }
        else {return 0.0;}
    }

}


    
