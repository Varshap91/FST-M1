package Activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Tom");
        plane.onboard("Jerry");
        plane.onboard("Minnie");
        System.out.println("Plane take off time: " + plane.takeOff());
        System.out.println("People on the plane: " + plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landed time: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}
