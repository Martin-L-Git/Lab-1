package src;
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

    public void setX (double x) {
        this.x = x;
    }

    public void setY (double y) {
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


}