import java.io.*;

/**
 * task: print a right-aligned staircase of size n, using # symbols and spaces.
 * The last line must have 0 spaces in it.
 * ex: a staircase of size n=4
 *      #
 *     ##
 *    ###
 *   ####
 */

class Result {

    /*
     * Complete the 'staircase' function below.
     * The function accepts INTEGER n as parameter.
     */
    public static void staircase(int n) {
        // Write your code here
        if (n<=0 || n>100) {
            System.out.println("n must be a value between 1 and 100 included");
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (j<n-i-1) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
