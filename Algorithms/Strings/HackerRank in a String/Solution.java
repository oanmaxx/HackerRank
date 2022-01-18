import java.io.*;
import java.util.stream.*;

/**
 * Task:
 * A string contains the word hackerrank if a subsequence of its characters spell the word hackerrank.
 * Remember that a subsequence maintains the order of characters selected from a sequence.
 * For each query, print YES on a new line if the string contains hackerrank, otherwise, print NO.
 * Example:
 *      INPUT:      s = haacckkerrannkk
 *                  s = hereiamstackerrank                  Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank,
 *                                                          we return YES.
 *                  s = hccaakkerrannkk                     There is no 'c' after the first occurrence of an 'a', so answer NO.
 *
 *      OUTPUT:     YES
 *                  YES
 *                  NO
 *
 *
 */

class Result {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
        // Write your code here
       return stringMatches(s) ? "YES" : "NO";
    }

    private static boolean stringMatches(String string) {
        String hackerrank = "hackerrank";
        int countMatchedChars = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == hackerrank.charAt(countMatchedChars)) {
                countMatchedChars++;
            }
            if (countMatchedChars == hackerrank.length()) {
                return true;
            }
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
