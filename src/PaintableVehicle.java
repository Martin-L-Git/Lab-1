public class PaintableVehicle {
    
    Vehicle vehicle;
    String image;

    public PaintableVehicle(Vehicle vehicle, String image){
        this.vehicle = vehicle;
        this.image = image;
    }

    public void gas(double amount){
        vehicle.gas(amount);
    }

    public void move(){
        vehicle.move();
    }

    public Position getPosition(){
        return vehicle.getPosition();
    }

}
