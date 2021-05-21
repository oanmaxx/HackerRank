import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner userInput = new Scanner(System.in);
        BigInteger a = new BigInteger(userInput.next());
        BigInteger b = new BigInteger(userInput.next());

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}