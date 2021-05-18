import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        //convert string to lowercase
        if (a.length() != b.length()) {
            return false;
        }

        a=a.toLowerCase();
        b=b.toLowerCase();
        //array for character frequency
        int[] frequency=new int[26];

        //loop through first string
        for(int i=0; i<a.length(); i++) {
            //index counts the frequency of each character in the string
            int indexA=a.charAt(i)-'a';
            frequency[indexA]++;
        }

        //loop through second array and decrement the frequency
        for (int j=0; j<b.length(); j++) {
            int indexB=b.charAt(j)-'a';
            frequency[indexB]--;
        }

        //if all the indexes of frequency array come to zero -> a and b strings are anagram
        for (int k=0; k<26; k++) {
            if (frequency[k]!=0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
