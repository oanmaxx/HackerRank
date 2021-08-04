import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * task: complete the aVeryBigSum function.
 * Calculate and print the sum of the elements in an array
 * (keeping in mind that some of those integers may be quite large).
 */

class Result {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static BigInteger aVeryBigSum(List<Long> ar) {
        // Write your code here
        BigInteger sum = BigInteger.ZERO;
        for (long arrElem : ar) {
            BigInteger elem = BigInteger.valueOf(arrElem);
            sum = sum.add(elem);
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        BigInteger result = Result.aVeryBigSum(ar);

        bufferedWriter.write(result.toString());
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
