import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * There is a large pile of socks that must be paired by color.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 */

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER:
     * 1. INTEGER nrOfMatchingPairs
     * The function accepts following parameters:
     *  1. INTEGER n = the number of socks in the pile
     *  2. INTEGER_ARRAY ar = the colors of each sock
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> pairOfSocks = new HashMap<>();
        int nrOfMatchingPairs = 0;

        for (int sockColor : ar) {
           if (!pairOfSocks.containsKey(sockColor)) {
               pairOfSocks.put(sockColor, 1);
           } else {
               pairOfSocks.remove(sockColor);
               ++nrOfMatchingPairs;
           }
        }
        return nrOfMatchingPairs;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
