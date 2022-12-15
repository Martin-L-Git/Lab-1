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

    ArrayList<PaintableVehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<PaintableVehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        // Print an error message in case file is not found with a try/catch block
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PaintableVehicle vehicle : vehicles)
        g.drawImage(vehicle.image, (int)vehicle.getPosition().getX(), (int)vehicle.getPosition().getY(), null);
        
        
    }
}
