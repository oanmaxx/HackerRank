import java.util.*;

/**
 *  read n lines of input until you reach EOF,
 *  then number and print all n lines of content.
 */

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int counter = 1;

        while (scan.hasNext()) {
            System.out.println(counter + " " + scan.nextLine());
            counter++;
        }
        scan.close();
    }
}
