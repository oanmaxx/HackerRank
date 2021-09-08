import java.io.*;

/**
 * You are choreographing a circus show with various animals.
 * For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
 * The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
 * The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
 * Task:
 *      You have to figure out a way to get both kangaroos at the same location at the same time as part of the show.
 *      If it is possible, return YES, otherwise return NO.
 * Sample INPUT:
 *      2 1 1 2             x1 v1 x2 v2
 * Sample OUTPUT:
 *      YES                 after one jump they are both at x3(x1+v1=2+1, x2+v2=1+2), so the answer is YES
 * ex: 0 2 5 3
 *     NO
 *     0 3 4 2
 *     YES
 */

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1 = starting position for kangaroo one
     *  2. INTEGER v1 = jump distance for kangaroo two
     *  3. INTEGER x2 = starting position for kangaroo two
     *  4. INTEGER v2 = jump distance for kangaroo two
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        int jump = 0;
        while (jump < v1*x2) {
            if (x1+v1*jump == x2+v2*jump) {
                return "YES";
            }
            jump++;
        }
        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
