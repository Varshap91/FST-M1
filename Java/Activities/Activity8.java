package Activities;

public class Activity8 {

    static void exceptionTest(String msg) throws CustomException {
        if(msg == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(msg);
        }
    }
    public static void main(String[] args) {
        try {
            // Method call with correct input
            Activity8.exceptionTest("Will print to console");
            // Method call with incorrect input
            Activity8.exceptionTest(null);
            // Exception is thrown here
            Activity8.exceptionTest("Won't execute");
        } catch(CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }
}
