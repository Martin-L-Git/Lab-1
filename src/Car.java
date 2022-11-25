package src;
import java.awt.*;

public abstract class Car implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed = 0; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Position position;

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.position = new Position(0, 0);
        stopEngine();
    }

    // Setters

    public void setColor(Color clr) {
        color = clr;
    }

    // Getters

    public String getmodelName() {
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

    public Position getPosition() {
        return position;
    }


    // Public, callable Car methods

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
        switch (position.getDirection()) {
            case UP:
                position.decreaseY(currentSpeed);
                break;

            case RIGHT:
                position.increaseX(currentSpeed);
                break;

            case DOWN:
                position.increaseY(currentSpeed);
                break;

            case LEFT:
                position.decreaseX(currentSpeed);
                break;
        }
    }

    public void turnLeft() {
        position.decrementDirection();
    }

    public void turnRight() {
        position.incrementDirection();
    }

    // Car private & protected implementation methods

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}