import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.hamcrest.core.IsInstanceOf;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize

    BufferedImage VolvoImage;
    BufferedImage SaabImage;
    BufferedImage ScaniaImage;

    // To keep track of a single cars position
    
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    ArrayList<Point> vehiclePoints = new ArrayList<>();

    void moveit(Vehicle v, int x, int y){
        if (v instanceof Saab95){
            saabPoint.x = x;
            saabPoint.y = y;
        }
        if (v instanceof Volvo240){
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        if (v instanceof Scania){
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }

    }
    

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        vehiclePoints.add(saabPoint);
        vehiclePoints.add(volvoPoint);
        vehiclePoints.add(scaniaPoint);

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            VolvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            SaabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            ScaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(VolvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(SaabImage, saabPoint.x, (saabPoint.y+100), null);
        g.drawImage(ScaniaImage, scaniaPoint.x, (scaniaPoint.y+200), null);
        
    }
}
