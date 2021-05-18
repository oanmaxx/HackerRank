import java.util.Scanner;
//Given a string,s, and an integer,k, complete the function so that it finds the lexicographically smallest and largest substrings of length .

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        smallest = s.substring(0, k);
        largest = s.substring(0, k);

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i=0; i<=s.length()-k; i++) {
            String substring = s.substring(i, i+k);
            if(smallest.compareTo(substring)>0) {
                smallest = substring;
            }
            if(largest.compareTo(substring)<0) {
                largest = substring;
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
