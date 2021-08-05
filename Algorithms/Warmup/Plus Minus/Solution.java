import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * task: given an array of integers,
 * calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with 6 places after the decimal.
 */

class Result {

    /*
     * Complete the 'plusMinus' function below.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int arrElemsNumber = arr.size();
        int countPositives = 0, countNegatives = 0, countZeros = 0;
        for (Integer element : arr) {
            if (element > 0) {
                countPositives++;
            }
            if (element < 0) {
                countNegatives++;
            }
            if (element == 0) {
                countZeros++;
            }
        }

        //proportion of positive values
        System.out.printf("%.6f\n", countPositives/(float)arrElemsNumber);
        //proportion of negative values
        System.out.printf("%.6f\n", countNegatives/(float)arrElemsNumber);
        //proportion of zeros
        System.out.printf("%.6f\n", countZeros/(float)arrElemsNumber);
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
