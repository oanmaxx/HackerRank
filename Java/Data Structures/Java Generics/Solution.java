import java.io.IOException;
import java.lang.reflect.Method;

/**
 *  write a single method printArray that is able to accept both integer arrays or string array.
 */

class Printer {
    //Write your code here
    public static <T> void printArray(T[] inputArray) {
        for(T element : inputArray) {
            System.out.println(element);
        }
    }
}

public class Solution {

    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
    }
}