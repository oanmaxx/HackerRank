import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * task: given five positive integers, find the minimum and maximum values
 * that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values
 * as a single line of two space-separated long integers.
 */

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int max = arr.get(0), min = arr.get(0);
        long sum = 0;
        for (Integer value : arr) {
            sum += value;
            if (value < max) {
                max = value;
            }
            if (value > min) {
                min = value;
            }
        }
        System.out.println((sum-min) + " " + (sum-max));
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
