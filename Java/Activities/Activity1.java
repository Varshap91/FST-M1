package Activities;

public class Activity1 {
    public static void main(String[] args) {
        Car Honda = new Car();
        Honda.make = 2014;
        Honda.color = "Black";
        Honda.transmission = "Manual";

        System.out.println("Car details:");
        Honda.displayCharacteristics();
        System.out.println(" ");
        Honda.accelerate();
        System.out.println(" ");
        Honda.brake();

    }
}
