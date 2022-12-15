import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private final static int delay = 50;
    private static Timer timer = new Timer(delay, new TimerListener());
    private static ArrayList<PaintableVehicle> vehicles;
    private static CarView view;

    public static void main(String[] args) {

        vehicles = new ArrayList<>();

        PaintableVehicle volvo = new PaintableVehicle(new Volvo240(), "pics/Volvo240.jpg");
        PaintableVehicle saab = new PaintableVehicle(new Saab95(), "pics/Saab95.jpg");
        saab.getPosition().setY(100);
        PaintableVehicle scania = new PaintableVehicle(new Scania(), "pics/Scania.jpg");
        scania.getPosition().setY(200);

        vehicles.add(volvo);
        vehicles.add(saab);
        vehicles.add(scania);

        CarController controller = new CarController(vehicles);

        // Start a new view and send a reference of self
        view = new CarView("CarSim 1.0", controller, vehicles);

        // Start the timer
        timer.start();
    }
    

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (PaintableVehicle vehicle : vehicles) {
                vehicle.move();
                view.drawPanel.repaint();
            }
        }
    }
}
