import java.util.*;
import java.lang.*;

/**
 * Task:
 * Given an array of n distinct integers, transform the array into a zig zag sequence by permuting the array elements.
 * A sequence will be called a zig zag sequence if the first k elements in the sequence are in increasing order and the last k elements are in decreasing order, where k=(n+1)/2.
 * You need to find the lexicographically smallest zig zag sequence of the given array.
 * Debug the existing code to successfully execute all provided test files.
 * Note: You can modify at most three lines in the given code. You cannot add or remove lines of code.
 */
public class Solution {

    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        // original code: int mid = (n-1)/2;
        int mid = n/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        // original code: int ed = n - 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            // original code: ed = ed + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}



