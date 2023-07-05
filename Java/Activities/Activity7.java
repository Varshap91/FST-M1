package Activities;

public class Activity7 {
    public static void main(String args[]) {
        MountainBike Bike = new MountainBike(3, 0, 25);
        System.out.println(Bike.bicycleDesc());
        Bike.speedUp(20);
        Bike.applyBrake(5);
    }
}
