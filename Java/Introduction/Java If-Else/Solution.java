import java.util.*;

/**
 * given a integer n (1<=n<=100)
 * if n=odd -> print "Weird"
 * if n=even && in the inclusive range of 2 to 5 -> print "Not weird"
 * if n=even && in the inclusive range of 6 to 20 -> print "Weird"
 * if n=even && greater than 20  -> print "Not weird"
 */

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(N>=1 && N<=100) {
            if(!(N%2==0)) {
                System.out.println("Weird");
            }
            if((N>=6 && N<=20) && (N%2==0)) {
                System.out.println("Weird");
            }
            if((N%2==0) && ((N>=2 && N<=5) || (N>=21 && N<=100)))
                System.out.println("Not Weird");
        }
        scanner.close();
    }
}