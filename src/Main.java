import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    private final static int delay = 50;
    private static Timer timer = new Timer(delay, new TimerListener());
    private static ArrayList<Vehicle> vehicles;
    private static CarView view;

    public static void main(String[] args) {
        // Instance of this class

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Volvo240());
        vehicles.add(new Saab95());
        vehicles.add(new Scania());

        CarController cc = new CarController(vehicles);

        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.0", cc);

        // Start the timer
        timer.start();
    }

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition().getX());
                int y = (int) Math.round(vehicle.getPosition().getY());
                view.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                view.drawPanel.repaint();
            }
        }
    }
}
