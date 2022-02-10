import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * A matching pair of brackets(an opening bracket, i.e., (, [, or { occurs to the left of a closing bracket, i.e., ), ], or } of the exact same type)
 * is not balanced if the set of brackets it encloses are not matched.
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 *      - it contains no unmatched brackets.
 *      - the subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 *
 * Task:
 *      Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
 */

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> brackets = new Stack<>();
        boolean result = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                brackets.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (brackets.isEmpty()) {
                   result = false;
                   break;
                }
            }

            if (s.charAt(i) == ')') {
                if (brackets.peek() == '(') {
                    brackets.pop();
                } else {
                    result = false;
                    break;
                }
            }

            if (s.charAt(i) == ']') {
                if (brackets.peek() == '[') {
                    brackets.pop();
                } else {
                    result = false;
                    break;
                }
            }

            if (s.charAt(i) == '}') {
                if (brackets.peek() == '{') {
                    brackets.pop();
                } else {
                    result = false;
                    break;
                }
            }
        }
       if (!brackets.isEmpty()) {
           result = false;
       }
       if (result) {
           return "YES";
       } else {
           return "NO";
       }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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
