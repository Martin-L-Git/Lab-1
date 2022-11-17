package test;

import src.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class carTest {

    @Test
    public void testing_default_direction() {
        Car volvo = new Volvo240();
        assertEquals(Direction.UP, volvo.getDirection());
    }

    @Test
    public void testing_direction_after_turning_left() {
        Car volvo = new Volvo240();
        volvo.turnLeft();
        assertEquals(Direction.LEFT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Direction.DOWN, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Direction.RIGHT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Direction.UP, volvo.getDirection());
    }

    @Test
    public void testing_direction_after_turning_right() {
        Car volvo = new Volvo240();
        volvo.turnRight();
        assertEquals(Direction.RIGHT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Direction.DOWN, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Direction.LEFT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Direction.UP, volvo.getDirection());
    }

    @Test
    public void testing_startEngine() {
        Car car = new Volvo240();
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed(), 0);

    }

    @Test
    public void testing_stopEngine() {
        Car car = new Saab95();
        car.startEngine();
        car.stopEngine();
        assertEquals(0.0, car.getCurrentSpeed(), 0);
    }

    @Test
    public void testing_gas_for_volvo() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(1);
        assertEquals(1.25, volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void testing_gas_for_saab() {
        Saab95 saab = new Saab95();
        saab.gas(1);
        assertEquals(1.25, saab.getCurrentSpeed(), 0);
        saab.setTurboOn();
        saab.gas(1);
        assertEquals(2.875, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testing_brake_for_volvo() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(1); // Speed is now 1,25, see gas method
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void testing_brake_for_saab() {
        Saab95 saab = new Saab95();
        saab.gas(1); // Speed is now 1,25, see gas method
        saab.brake(1);
        assertEquals(0, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testing_move() {
        Car car = new Volvo240(); // Default direction == UP
        car.gas(1); // Setting currentSpeed to 1.25
        car.move();
        assertEquals(-1.25, car.getY(), 0);

        car.turnRight(); // Direction == RIGHT
        car.move();
        assertEquals(1.25, car.getX(), 0);

        car.turnRight(); // Direction == DOWN
        car.move();
        assertEquals(0, car.getY(), 0);

        car.turnRight(); // Direction == LEFT
        car.move();
        assertEquals(0, car.getX(), 0);
    }

}
