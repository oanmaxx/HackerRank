import java.io.*;
import java.util.HashSet;

import java.util.Set;

/**
 * A pangram is a string that contains every letter of the alphabet.
 * Given a sentence determine whether it is a pangram in the English alphabet.
 * Ignore case.
 * Task: Return either pangram or not pangram as appropriate.
 * Examples:
 *      Sample INPUT 1:
 *              The quick brown fox jumps over the lazy dog                             the string contains all letters in the English alphabet
 *      Sample OUTPUT 1:
 *              pangram
 *      Sample INPUT 2:
 *              We promptly judged antique ivory buckles for the next prize             all of the letters of the alphabet are present in the string
 *      Sample OUTPUT 2:
 *              pangram
 *      Sample INPUT 3:
 *              We promptly judged antique ivory buckles for the prize                  the string lacks an x
 *      Sample OUTPUT 3:
 *              not pangram
 */

class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING "pangram" if the input string is a pangram or not pangram if it is not a pangram.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Write your code here
        String stringLowCase = s.toLowerCase();
        String result="";

        // the alphabet container holds each character of the input string
        Set<Character> alphabet = new HashSet<>();

        // iterate through string and
        for (int i=0; i<stringLowCase.length(); i++) {
            // if the character is a letter
            if (stringLowCase.charAt(i) != ' ') {
                // add it to the alphabet
                alphabet.add(stringLowCase.charAt(i));
            }
            // if the set has all letters in English alphabet, then the string is a pangram
            if (alphabet.size() == 26) {
                result = "pangram";
            } else {
                //otherwise it is not a pangram
                result = "not pangram";
            }
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
