import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Given a string s, remove characters until the string is made up of any two alternating characters.
 * When you choose a character to remove, all instances of that character must be removed.
 * TASK: Determine the longest string possible, t, that contains just two alternating letters and return its length.
 *
 * Example:
 *      Sample INPUT:
 *                      10                  the length of s
 *                      beabeefeab          string s
 *      Sample OUTPUT:
 *                      5
 *
 * Explanation:
 *      The characters present in s are a, b, e, f. This means that t must consist of two of those characters
 *      and you must delete two others. Your choices for characters to leave are [a,b], [a,e], [a, f], [b, e], [b, f] and [e, f].
 *      If you delete e and f, the resulting string is babab. This is a valid string t as there are only two distinct characters
 *      (a and b), and they are alternating within the string. If we delete a and f, the resulting string is bebeeeb. This is not a valid string t
 *      because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string t.
 *      Other cases are solved similarly.
 *      babab is the longest string you can create, so the result is 5.
 */

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER representing the length of the longest valid string, or 0 if there are none
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        // Write your code here
        int max=0, tLength;

        // finding all unique characters in the string
        Set<Character> stringUniqueChars = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            stringUniqueChars.add(s.charAt(i));
        }

        List<Character> uniqueCharsList = new ArrayList<>(stringUniqueChars);
        // create all possible combinations of 2 characters from the unique characters that we found
        for (int i=0; i<uniqueCharsList.size()-1; i++) {
            for (int j=i+1; j<uniqueCharsList.size(); j++) {
                char characterOne = uniqueCharsList.get(i);
                char characterTwo = uniqueCharsList.get(j);
                // delete other characters from string s except the current pair of characters
                String t = Pattern.compile("[^" + characterOne + "" + characterTwo + "]").matcher(s).replaceAll("");
                // if the examined pair contains alternating chars then count the length of resulting string t
                if (isAlternating(t)) {
                    // keep a running maximum length of valid strings
                    tLength = t.length();
                    max = Math.max(max, tLength);
                }
            }
        }
        // the maximum of string t lengths
        return max;
    }

    // verify if the examined pair contains alternating characters
    private static boolean isAlternating(String str) {
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
