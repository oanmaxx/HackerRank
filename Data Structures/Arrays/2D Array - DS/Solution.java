import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Task:
 * Given a 6x6 2D array, calculate the hourglass sum for every hourglass in array,
 * then print the maximum hourglass sum.
 * An 6x6 2D array:
 *              1 1 1 0 0 0
 *              0 1 0 0 0 0
 *              1 1 1 0 0 0
 *              0 0 2 4 4 0
 *              0 0 0 2 0 0
 *              0 0 1 2 4 0
 * An hourglass in array is a subset of values with indices falling in this pattern in
 * array's graphical representation.
 *          1 1 1
 *            1
 *          1 1 1
 *
 */

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER: the maximum hourglass sum.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter: int arr[6][6] of integers.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i>1 && j>1) {
                    int sum = arr.get(i).get(j) + arr.get(i).get(j-1) + arr.get(i).get(j-2)
                            + arr.get(i-1).get(j-1)
                            + arr.get(i-2).get(j) + arr.get(i-2).get(j-1) + arr.get(i-2).get(j-2);
                    if (sum>maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
