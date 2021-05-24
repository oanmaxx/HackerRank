import java.util.*;
/**
 * Given an array of n integers, find and print its number of negative subarrays on a new line.
 */

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int arr[] = new int[n];
        System.out.println("input elements in arr: ");
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        for (int j=0; j<n; j++) {
            int sum = 0;
            for (int k=j; k<n; k++) {
                sum = arr[k]+sum;
                if (sum<0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
