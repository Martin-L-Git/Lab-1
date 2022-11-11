
public class Main {
    public static void main(String[] args) {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.move();
        volvo.stopEngine();
        System.out.println(volvo.getDirection());
        System.out.println(volvo.getY());

    }
}