import java.io.*;
import java.math.BigInteger;

/**
 * We define a super digit of an integer x using the following rules:
 * Given an integer, we need to find the super digit of the integer.
 *      - If x has only 1 digit, then its super digit is x.
 *      - Otherwise, the super digit of x is equal to the super digit of the sum of the digits of x.
 * Complete the function superDigit in the editor below. It must return the calculated super digit as an integer.
 * Example:
 *      INPUT:
 *              n = "9875987598759875"
 *              k = 16
 *      OUTPUT:
 *              8
 *
 *      superDigit(p) = superDigit(9875987598759875)
 *                      9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
 *      superDigit(p) = superDigit(116)
 *                      1+1+6 = 8
 *      superDigit(p) = superDigit(8)
 */


class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER: the super digit of n repeated k times.
     * The function accepts following parameters:
     *  1. STRING n: a string representation o an integer
     *  2. INTEGER k: the times to concatenate n to make p
     */

    public static int superDigit(String n, int k) {
        // Write your code here
        // int p: concatenate the string n k times
        BigInteger result = calculateSum(n).multiply(BigInteger.valueOf(k));
        k = result.toString().length();
        while (k > 1) {
            result = calculateSum(result.toString());
            k = result.toString().length();
        }
        return result.intValue();
    }

    private static BigInteger calculateSum(String str) {
        BigInteger sum = BigInteger.ZERO;
        char[] numbers = str.toCharArray();
        for (char number : numbers) {
            sum = sum.add(BigInteger.valueOf(Long.parseLong(String.valueOf(number))));
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
