import java.io.*;
import java.util.*;

/**
 * Interview Preparation Kit - Arrays - Minimum Swaps 2
 * Task:
 * Given an unordered array consisting of consecutive integers without any duplicates,
 * you are allowed to swap any two elements.
 * Find the minimum number of swaps required to sort the array in ascending order.
 * Example:
 *      Sample INPUT:
 *                  arr=[4, 3, 1, 2]          swap(0, 2)  arr=[1, 3, 4, 2]
 *                                            swap(1, 2)  arr=[1, 4, 3, 2]
 *                                            swap(1, 3)  arr=[1, 2, 3, 4]
 *      Sample OUTPUT:
 *                  3                        a minimum of 3 swaps to sort the array in ascending order
 */

public class Solution {

    /**
     * Complete the minimumSwaps function below.
     *
     * @param arr: an unordered array of integers
     * @return an integer: the minimum number of swaps to sort the array
     */
    static int minimumSwaps(int[] arr) {
        int countMinSwaps = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                int temp = arr[index];
                arr[index] = arr[temp-1];
                arr[temp-1] = temp;
                countMinSwaps++;
                index--;
            }
        }
        return countMinSwaps;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
