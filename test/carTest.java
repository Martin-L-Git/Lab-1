
import java.awt.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class carTest {

    @Test
    public void default_direction() {
        Car volvo = new Volvo240();
        assertEquals(Direction.UP, volvo.getPosition().getDirection());
    }

    @Test
    public void direction_after_turning_left() {
        Car volvo = new Volvo240();
        volvo.turnLeft();
        assertEquals(Direction.LEFT, volvo.getPosition().getDirection());
        volvo.turnLeft();
        assertEquals(Direction.DOWN, volvo.getPosition().getDirection()); // Is this really the way to do this?
        volvo.turnLeft();
        assertEquals(Direction.RIGHT, volvo.getPosition().getDirection());
        volvo.turnLeft();
        assertEquals(Direction.UP, volvo.getPosition().getDirection());
    }

    @Test
    public void direction_after_turning_right() {
        Car volvo = new Volvo240();
        volvo.turnRight();
        assertEquals(Direction.RIGHT, volvo.getPosition().getDirection());
        volvo.turnRight();
        assertEquals(Direction.DOWN, volvo.getPosition().getDirection());
        volvo.turnRight();
        assertEquals(Direction.LEFT, volvo.getPosition().getDirection());
        volvo.turnRight();
        assertEquals(Direction.UP, volvo.getPosition().getDirection());
    }

    @Test
    public void startEngine_changes_currentSpeed() {
        Car car = new Volvo240();
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed(), 0);
    }

    @Test
    public void stopEngine_sets_currentSpeed_to_zero() {
        Car car = new Saab95();
        car.startEngine();
        car.stopEngine();
        assertEquals(0.0, car.getCurrentSpeed(), 0);
    }

    @Test
    public void gas_for_volvo() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(1);
        assertEquals(1.25, volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void gas_for_saab() {
        Saab95 saab = new Saab95();
        saab.gas(1);
        assertEquals(1.25, saab.getCurrentSpeed(), 0);
        saab.setTurboOn();
        saab.gas(1);
        assertEquals(2.875, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void gas_only_takes_argument_between_0_and_1() {
        Car car = new Volvo240();
        car.gas(1); // currentSpeed now 1.25
        assertEquals(1.25, car.getCurrentSpeed(), 0);
        car.gas(100);
        assertEquals(1.25, car.getCurrentSpeed(), 0); // currentSpeed unchanged
        car.gas(-100);
        assertEquals(1.25, car.getCurrentSpeed(), 0); // currentSpeed unchanged

    }

    @Test
    public void brake_only_takes_argument_between_0_and_1() {
        Car car = new Volvo240();
        car.gas(1); // currentSpeed now 1.25
        car.brake(1);
        assertEquals(0, car.getCurrentSpeed(), 0);
        car.brake(100);
        assertEquals(0, car.getCurrentSpeed(), 0); // currentSpeed still zero
        car.brake(-100);
        assertEquals(0, car.getCurrentSpeed(), 0); // currentSpeed still zero
    }

    @Test
    public void brake_for_volvo() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(1); // Speed is now 1,25, see gas method
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void brake_for_saab() {
        Saab95 saab = new Saab95();
        saab.gas(1); // Speed is now 1,25, see gas method
        saab.brake(1);
        assertEquals(0, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void move_changes_x_or_y_value() {
        Car car = new Volvo240(); // Default direction == UP
        car.gas(1); // Setting currentSpeed to 1.25
        car.move();
        assertEquals(-1.25, car.getPosition().getY(), 0);

        car.turnRight(); // Direction == RIGHT
        car.move();
        assertEquals(1.25, car.getPosition().getX(), 0);

        car.turnRight(); // Direction == DOWN
        car.move();
        assertEquals(0, car.getPosition().getY(), 0);

        car.turnRight(); // Direction == LEFT
        car.move();
        assertEquals(0, car.getPosition().getX(), 0);
    }

    @Test
    public void get_nr_of_doors() {
        Car saab = new Saab95();
        Car volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors());
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void get_model_name() {
        Car saab = new Saab95();
        Car volvo = new Volvo240();
        assertEquals("Volvo240", volvo.getmodelName());
        assertEquals("Saab95", saab.getmodelName());
    }

    @Test
    public void get_x_returns_x() {
        Car car = new Volvo240();
        car.turnRight(); // Turning car right so move() changes x-value
        car.gas(1); // Setting currentSpeed to 1.25
        car.move();
        assertEquals(1.25, car.getPosition().getX(), 0);
    }

    @Test
    public void get_y_returns_y() {
        Car car = new Volvo240(); // Default direction is UP, y-value is affected by gas
        car.gas(1); // Setting currentSpeed to 1.25
        car.move();
        assertEquals(-1.25, car.getPosition().getY(), 0);
    }

    @Test
    public void get_enginePower_returns_enginePower() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        assertEquals(125, saab.getEnginePower(), 0);
        assertEquals(100, volvo.getEnginePower(), 0);
    }

    @Test
    public void get_color_returns_color() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        assertEquals(Color.red, saab.getColor());
        assertEquals(Color.black, volvo.getColor());
    }

    @Test
    public void loading_car_in_carTransport_works() {
        CarTransport ct = new CarTransport(6);
        Saab95 saab = new Saab95();
        saab.getPosition().setX(8.2);
        ct.getPosition().setX(10);
        assertEquals(0, ct.getLoadedCarsSize());
        ct.lowerPlatform();
        ct.loadCar(saab);
        assertEquals(1, ct.getLoadedCarsSize());
    }

    @Test
    public void cannot_raise_ramp_while_Scania_is_moving() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.raisePlatform();
        assertEquals(false, scania.getPlatform().isUp());
    }

    @Test
    public void cars_are_unloaded_close_to_repair_shop() {
        CarRepairShop carRepairShop = new CarRepairShop(0, 0, 12);
        Car car = new Volvo240();
        carRepairShop.loadCar(car);
        carRepairShop.unloadCar(car);
        assertEquals(2, car.getPosition().getX(), 0);
        assertEquals(2, car.getPosition().getY(), 0);

    }

}
