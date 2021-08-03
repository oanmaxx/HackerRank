import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * A reviewer rates two challenges, awarding points on a scale from 1 to 100
 * for three categories: problem clarity, originality, and difficulty.
 * The rating for a's challenge is the triplet a = (a[0], a[1], a[2]),
 * and the rating for b's challenge is the triplet b = (b[0], b[1], b[2]).
 * task: find the comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].
 *      - if a[i] > b[i], then a is awarded 1 point.
 *      - if a[i] < b[i], then b is awarded 1 point.
 *      - if a[i] = b[i], then neither a and b receives a point.
 *      Given a and b, determine their respective comparison points.
 */

class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        // Write your code here
        Integer[] comparisonPoints = new Integer[2];
        for (Integer indexA : a) {
            for (Integer indexB : b) {
                if (indexA>indexB) {
                    comparisonPoints[0]++;
                } else {
                    comparisonPoints[1]++;
                }
            }
        }
        return Arrays.asList(comparisonPoints);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

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
