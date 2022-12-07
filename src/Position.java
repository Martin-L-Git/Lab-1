
import java.util.*;

import static java.util.Arrays.asList;

public class Position {

    private double x;
    private double y;
    private Direction direction;
    private final List<Direction> directions;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
        this.direction = Direction.UP;
        this.directions = asList(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT);
    }

    public void setX (double x) {
        this.x = x;
    }

    public void setY (double y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
     public Direction getDirection() {
        return direction;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public void increaseX(double amount){
        x += amount;
    }

    public void increaseY(double amount){
        y += amount;
    }

    public void decreaseX(double amount){
        x -= amount;
    }

    public void decreaseY(double amount){
        y -= amount;
    }

    public void incrementDirection(){
        direction = directions.get((directions.indexOf(direction) + 1 + directions.size()) % directions.size());
    }

    public void decrementDirection(){
        direction = directions.get((directions.indexOf(direction) - 1 + directions.size()) % directions.size());
    }
    
    public double calculateDistance(double x1, double x2, double y1, double y2){
        double distance = Math.sqrt(Math.pow((x1 - x2), 2) + (Math.pow((y1 - y2), 2)));
        return distance;
    }

}