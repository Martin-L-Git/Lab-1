package src.set;
import java.awt.*;

import java.util.List;
import static java.util.Arrays.asList;

public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed = 0; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x; // Car x-coordinate
    private double y; // Car y-coordinate
    private Direction direction;
    private final List<Direction> directions;

    public Car(int nrDoors, Color color, double enginePower, String modelName, double x, double y, Direction direction) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.directions = asList(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT);
        this.direction = direction;
        stopEngine();
    }

    // Setters

    private void setX(double x) {
        this.x = x;
    }

    private void setY(double y) {
        this.y = y;
    }
    
    protected void setColor(Color clr) {
        color = clr;
    }

    // Getters

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getName() {
        return modelName;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    // Start, top, speed and movement methods


    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    public void move() {

        switch (direction) {
            case UP:
                y -= currentSpeed;
                break;

            case RIGHT:
                x += currentSpeed;
                break;

            case DOWN:
                y += currentSpeed;
                break;

            case LEFT:
                x -= currentSpeed;
                break;
        }
    }

    public void turnLeft() {
        direction = directions.get((directions.indexOf(direction) - 1 + directions.size()) % directions.size());
    }

    public void turnRight() {
        direction = directions.get((directions.indexOf(direction) + 1 + directions.size()) % directions.size());
    }

    protected abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

}