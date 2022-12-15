import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class PaintableVehicle {
    
    Vehicle vehicle;
    BufferedImage image;


    public PaintableVehicle(Vehicle vehicle, String image){
        this.vehicle = vehicle;
       
        try {

        this.image = ImageIO.read(DrawPanel.class.getResourceAsStream(image));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void gas(double amount){
        vehicle.gas(amount);
    }

    public void move(){
        vehicle.move();
    }

    public Position getPosition(){
        return vehicle.getPosition();
    }

}
