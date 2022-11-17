package src.set;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class carTest {

    @Test
    public void testing_default_direction(){
        Car volvo = new Volvo240();
        assertEquals(UP, System.out.println(volvo.direction))
    }

    @Test
    public void testing_direction_after_turning_left(){
        Car volvo = new Volvo240();
        volvo.turnLeft();
        assertEquals(LEFT, System.out.println(volvo.direction))
        volvo.turnLeft();
        assertEquals(DOWN, System.out.println(volvo.direction))
        volvo.turnLeft();
        assertEquals(RIGHT, System.out.println(volvo.direction))
        volvo.turnLeft();
        assertEquals(UP, System.out.println(volvo.direction))
    }
        
    
    @Test
    public void testing_direction_after_turning_right(){
        Car volvo = new Volvo240();
        volvo.turnRight();
        assertEquals(RIGHT, System.out.println(volvo.direction))
        volvo.turnRight();
        assertEquals(DOWN, System.out.println(volvo.direction))
        volvo.turnRight();
        assertEquals(LEFT, System.out.println(volvo.direction))
        volvo.turnRight();
        assertEquals(UP, System.out.println(volvo.direction))
    }



}