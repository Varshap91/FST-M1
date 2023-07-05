package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Varsha");
        myList.add("Apoorva");
        myList.add("Shreyas");
        myList.add("Tejas");
        myList.add("Nikki");

        System.out.println("List of all the names:");
        for (String name : myList) {
            System.out.println(name);
        }


        System.out.println("Third name in the list");
        String name1 = myList.get(2);
        System.out.println(name1);

        System.out.println("List has Nikki's name:" + myList.contains("Nikki"));
        System.out.println("List has Preethi's name:" + myList.contains("Preethi"));
        System.out.println("size of the list:" + myList.size());

        myList.remove("Shreyas");
        System.out.println("size of the list:" + myList.size());

        myList.remove(3);
        System.out.println("size of the list:" + myList.size());

        System.out.println("List of all the names:");
        for (String name2 : myList) {
            System.out.println(name2);
        }
    }
}

