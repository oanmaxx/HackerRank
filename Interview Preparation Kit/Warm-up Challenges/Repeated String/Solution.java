import java.io.*;
import java.util.*;

/**
 * Task:
 * There is a string, s, of lowercase English letters that is repeated infinitely many times.
 * Given an integer, n, find and print the number of letter a's in the first n letters of the infinite string.
 * Example:
 *      Sample INPUT:
 *                  s = 'abcac'
 *                  n = 10                  the substring to be considered is 'abcacabcac', the first 10 characters of the infinite string.
 *                                          there are 4 occurrences of a in the substring.
 *      Sample OUTPUT:
 *                  4
 */

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER: the frequency of "a" in the substring.
     * The function accepts following parameters:
     *  1. STRING s: a string to repeat
     *  2. LONG_INTEGER n: the number of characters to consider
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long letterAFrequency;
        long timesFullString = n/s.length();
        long leftLettersString = n%s.length();
        List<Integer> letterAStringPositions = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                letterAStringPositions.add(i);
            }
        }

        letterAFrequency = (letterAStringPositions.size() * timesFullString) + (letterAStringPositions.stream().filter(a -> a < leftLettersString)).count();

        return letterAFrequency;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
