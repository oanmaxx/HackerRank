import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Task:
 * Starting with a 1-indexed array of zeros and a list of operations,
 * for each operation add a value to each the array element between two given indices, inclusive.
 * Once all operations have been performed, return the maximum value in the array.
 *
 * Example:
 *      Sample INPUT:
 *                  5 3                     n = 5, queries = 3
 *                  1 2 100                 list = {100 100 0 0 0}
 *                  2 5 100                 list = {100 200 100 100 100}
 *                  3 4 100                 list = {100 200 200 200 100}
 *      Sample OUTPUT
 *                  200                     the maximum value of the list
 */

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER: the maximum value in the resultant array
     * The function accepts following parameters:
     *  1. INTEGER n: the number of elements in the array
     *  2. 2D_INTEGER_ARRAY queries: a two-dimensional array of queries where each queries[i] contains three integers, a, b, and k
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long maxValueArray = 0;
        long[] array = new long[n];
        for (List<Integer> query : queries) {
            for (int i = query.get(0) - 1; i < query.get(1); i++) {
                array[i] = array[i] + query.get(2);
            }
        }

        for (long l : array) {
            if (l > maxValueArray) {
                maxValueArray = l;
            }
        }
        return maxValueArray;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
