import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with 6 places after the decimal.
 */

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int nrOfIntegers = arr.size();
        int negatives = 0, positives = 0, zeros = 0;
        for (Integer integer : arr) {
            if (integer > 0) {
                positives++;
            } else if (integer < 0) {
                negatives++;
            } else {
                zeros++;
            }
        }
        System.out.printf("%.6f\n", (float)positives/nrOfIntegers);         // proportion of positive values
        System.out.printf("%.6f\n", (float)negatives/nrOfIntegers);         // proportion of negatives values
        System.out.printf("%.6f\n", (float)zeros/nrOfIntegers);             // proportion of zeros values
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
