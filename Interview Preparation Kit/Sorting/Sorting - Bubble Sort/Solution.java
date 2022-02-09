import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm (swapping adjacent elements if they are in decreasing order).
 * Once sorted, print:
 *      1. Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
 *      2. First Element: firstElement, where firstElement is the first element in the sorted array.
 *      3. Last Element: lastElement, where lastElement is the last element in the sorted array.
 */

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int numSwaps = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size()-1; j++) {
                if (a.get(j) > a.get(j+1)) {
                    Collections.swap(a, a.indexOf(a.get(j)), a.indexOf(a.get(j+1)));
                    numSwaps++;
                }
            }
        }
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size()-1));
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}
