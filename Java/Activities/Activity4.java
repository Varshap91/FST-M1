package Activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] intArray = {3, 5, 1, 7, 4, 10, 9};
        System.out.println("Initial order: " + Arrays.toString(intArray));
        sortData(intArray);
        System.out.println("Sorted Data: " + Arrays.toString(intArray));
    }

    public static void sortData(int array[]) {
        int size = array.length, i;

        for (i = 0; i < size; i++) {
            int j = array[i];
            int k = i - 1;

            while (k >= 0 && j < array[k]) {
                array[k + 1] = array[k];
                --k;
            }
            array[k + 1] = j;
        }
    }
}

