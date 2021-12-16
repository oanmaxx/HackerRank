import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Task:
 * Given an array of integers, where all elements but one occur twice,
 * find the unique element.
 */

class Result {

    /*
     * Complete the 'lonelyInteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyInteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> pairedIntegers = new HashMap<>();
        // if the map contains a key equals to that number, then there is a pair(delete that mapping)
        // else add the number to the map
        for (Integer number : a) {
            if (pairedIntegers.containsKey(number)) {
                pairedIntegers.remove(number);
            } else {
                pairedIntegers.put(number, 1);
            }
        }

        // the lonely integer will be the only key that remains in the map
        Object[] theKey = pairedIntegers.keySet().toArray();
        return (int) theKey[0];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lonelyInteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
