package Activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("Popeye");
        hs.add("Dexter");
        hs.add("Scooby");
        hs.add("Blossom");
        hs.add("Jerry");
        hs.add("Noddy");
        System.out.println("Size of the set: " + hs.size());
        hs.remove("Noddy");
        System.out.println("New size of the set: " + hs.size());

        if(hs.remove("Fairy")) {
            System.out.println("Fairy removed from the Set");
        } else {
            System.out.println("Fairy is not present in the Set");
        }

        if(hs.contains("Scooby")) {
            System.out.println("Scooby is present in the set");
        }
        else {
            System.out.println("Scooby is not present in the set");
        }
        System.out.println("Updated Set: " + hs);
    }
}
