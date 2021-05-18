import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        // Write your code here.
        //split the string into tokens
        s = s.replaceAll("[^A-Za-z !,?._'@]+", "");
        s = s.replaceAll("[!,?.@_']+", " ");
        String[] stringTokens = s.split(" ");

        //the number of tokens in string s
        int n = 0;
        for (String word : stringTokens) {
            String t = word.trim();
            if(!t.isEmpty()) {
                n++;
            }
        }

        // print each of the n tokens on a new line in the same order as they appear in input string s
        System.out.println(n);
        for (String word : stringTokens) {
            String t = word.trim();
            if(!t.isEmpty()) {
                System.out.println(word.trim());
            }
        }

        scan.close();
    }
}

