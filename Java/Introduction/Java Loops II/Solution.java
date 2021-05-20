import java.util.*;

/**
 * use the integers a,b, and n to create the following series:
 * (a + 2^0 x b), (a + 2^0 x b + 2^0 x b),...,(a + 2^0 x b + 2^0 x b + ... + 2^n-1 x b)
 * you are given q queries in the form of a, b, and n.
 * For each query, print the series corresponding to the given a, b, and n values
 * as a single line of n space-separated integers.
 */

class Solution{
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            String allTheValues = "";
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for(int j=0;j<n;j++) {
                int sum = a;
                for(int k=0;k<=j;k++) {
                    sum+=Math.pow(2, k) * b;
                }

                allTheValues += sum + " ";
            }
            System.out.println(allTheValues);
        }
        in.close();
    }
}
