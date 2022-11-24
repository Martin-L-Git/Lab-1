package src;
import java.awt.*;
import java.util.List;
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

    private void setX (double x) {
        this.x = x;
    }

    private void setY (double y) {
        this.y = y;
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

    public void move(double currentSpeed) {
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

}