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


    public Car(int nrDoors, Color color, double enginePower, String modelName, double x, double y, Direction direction){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        stopEngine();

        this.directions = asList(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT);
        this.direction = direction;

    }
    

    // Setters

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    

    // Gettersli

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    // Car methods

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
	    color = clr;
    }

    protected void startEngine(){
	    currentSpeed = 0.1;
    }

    protected void stopEngine(){
	    currentSpeed = 0;
    }
    
    // TODO fix this method according to lab pm

    protected void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm

    protected void brake(double amount){
        decrementSpeed(amount);
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