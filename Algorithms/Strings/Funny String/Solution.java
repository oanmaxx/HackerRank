import java.io.*;
import java.util.stream.*;

/**
 * Task:
 * Determine whether a string is funny or not.
 * To determine whether a string is funny, create a copy of the string in reverse e.g. abc -> cba.
 * Iterating through each string, compare the absolute difference in the ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the end.
 * If the list of absolute differences is the same for both strings, they are funny.
 * Determine whether a give string is funny. If it is, return Funny, otherwise return Not Funny.
 */

class Result {

    /*
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING: either Funny or Not Funny.
     * The function accepts STRING s as parameter: a string to test.
     */

    public static String funnyString(String s) {
        // Write your code here
        for (int i = 0; i < s.length()-1; i++) {
            int strDifference = Math.abs(s.charAt(i) - s.charAt(i+1));
            int reversedStrDifference = Math.abs(s.charAt(s.length()-i-1) - s.charAt(s.length()-i-2));
            if (strDifference != reversedStrDifference) {
                return "Not Funny";
            }
        }
        return "Funny";
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

                String result = Result.funnyString(s);

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
