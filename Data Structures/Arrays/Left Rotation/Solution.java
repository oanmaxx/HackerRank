import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
 * task: given an integer, d, rotate the array that many steps left and return the result.
 * example:
 *          INPUT:
 *                  5 4             //n=5(the array size), d=4(the number of left rotations to perform)
 *                  1 2 3 4 5       //the array to rotate
 *          OUTPUT: 5 1 2 3 4       //the rotated array
 */

class Result {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        Integer[] rotArray = new Integer[n];

        for (int oldIndex = 0; oldIndex < n; oldIndex++) {
            int newIndex = (oldIndex + n - d) % n;
            rotArray[newIndex] = arr.get(oldIndex);
        }

        return Arrays.asList(rotArray);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.rotateLeft(d, arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
