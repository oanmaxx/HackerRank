import java.io.*;
import java.util.Stack;

/**
 * Reduce a string of lowercase characters in range ascii[‘a’..’z’]by doing a series of operations.
 * In each operation, select a pair of adjacent letters that match, and delete them.
 * Delete as many characters as possible using this method and return the resulting string.
 * If the final string is empty, return Empty String.
 * Sample INPUT 0:
 *          aaabccddd
 * Sample OUTPUT 0:
 *          abd                 aaabccddd → abccddd → abddd → abd
 * Sample INPUT 1:
 *          aa                  aa → Empty String
 * Sample OUTPUT 1:
 *          Empty String
 * Sample INPUT 2:
 *          baab
 * Sample OUTPUT 2:
 *          Empty String        baab → bb → Empty String
 */

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String superReducedString(String s) {
        // Write your code here
        Stack<Character> stackChars = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char character = s.charAt(i);
            if (!stackChars.isEmpty() && character==stackChars.peek()) {
                stackChars.pop();
            } else {
                stackChars.push(character);
            }
        }

        if (stackChars.isEmpty()) {
            return "Empty String";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : stackChars) {
                stringBuilder.append(ch);
            }
            return stringBuilder.toString();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
