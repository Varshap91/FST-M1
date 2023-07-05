package Activities;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1, "Orange");
        colours.put(2, "Green");
        colours.put(3, "Red");
        colours.put(4, "Blue");
        colours.put(5, "Black");
        System.out.println("Map: " + colours);

        //Remove one color
        colours.remove(3);
        System.out.println("New Maps: " + colours);

        if(colours.containsValue("Green")) {
            System.out.println("Green color is present in the map");
        }
        else {
            System.out.println("Green color is not present in the map");
        }

        System.out.println("Size of the map: " + colours.size());
    }
}
