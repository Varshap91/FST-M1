package Activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] intArray = {10, 77, 10, 54, -11, 10};
        int sum = 30;
        int myNum = 10;
        System.out.println("Result: " + result(intArray, myNum, sum));
    }
    public static boolean result(int[] numbers, int myNum, int sum) {
        int x = 0;
        //Loop through array
        for (int number : numbers) {
            //If value is 10
            if (number == myNum) {
                //Add them
                x += myNum;
            }

            //Sum should not be more than 30
            if (x > sum) {
                break;
            }
        }

        //Return if condition is true
        return x == sum;
    }
}