import java.math.BigDecimal;
import java.util.*;

/**
 * given an array, s, of n real number strings, sort them in descending order.
 * each number must be printed in the exact same format as it was read from stdin(i.e., .1 printed as .1 and 0.1 printed as 0.1)
 * if two numbers represent numerically equivalent values (e.g., .1 equivalent with 0.1 ),
 * then they must be listed in the same order as they were received as input.
 * task: rearrange array s's elements according to the instructions above.
 */

class Solution {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n+2];
        for(int i=0;i<n;i++) {
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        /**
         * sort in descending order while preserving the contents of each String.
         * inside the comparator, we convert Strings to BigDecimal so that the change is not permanent
         * and the String's form for each number is preserved.
         */
        Arrays.sort(s, 0, n, (s1, s2) -> {
            BigDecimal bd1=new BigDecimal(s1);
            BigDecimal bd2=new BigDecimal(s2);
            return bd2.compareTo(bd1);
        });

        //Output
        for(int i=0;i<n;i++) {
            System.out.println(s[i]);
        }
    }
}