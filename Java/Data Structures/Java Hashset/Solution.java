import java.util.*;

/**
 * You are given  pairs of strings.
 * Two pairs (a,b) and (c,d) are identical if a=c and b=d.
 * That also implies (a,b) is not same as (b,a).
 * After taking each pair as input,
 * you need to print number of unique pairs you currently have.
 */

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        //Write your code here
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < t; i++) {
            set.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(set.size());
        }
    }
}