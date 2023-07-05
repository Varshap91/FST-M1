package Activities;

import javax.sound.midi.Soundbank;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres = 4;
    int doors = 4;

    public void displayCharacteristics() {
        System.out.println("Car Make:" + make);
        System.out.println("Car color:" + color);
        System.out.println("Car transmission mode:" + transmission);
        System.out.println("Number of doors:" + doors);
        System.out.println("Number of tyres:" + tyres);
    }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }
    public void brake() {
        System.out.println("Car has stopped.");
    }
}

