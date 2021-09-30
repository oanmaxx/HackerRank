import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

/* Two words are anagrams of one another if their letters can be rearranged to form the other word.
 * Given a string, split it into two contiguous substrings of equal length.
 * Task: Determine the minimum number of characters to change to make the two substrings into anagrams of one another.
 * Examples:
 *      Sample INPUT:   6                           the number of test cases
 *                      aaabbb
 *                      ab
 *                      abc
 *                      mnop
 *                      xyyx
 *                      xaxbbbxx
 *      Sample OUTPUT:  3                           (test case #1: s1=aaa, s2=bbb; we have to replace all three characters from the first string with 'b' to make the strings anagrams)
 *                      1                           (test case #2: s1=a, s2=b; you have to replace 'a' with 'b', which will generate "bb")
 *                      -1                          (test case #3: it is not possible for two strings of unequal length to be anagrams of one another)
 *                      2                           (test case #4: s1=mn, s2=op; we have to replace both the characters of first string ("mn") to make it an anagram of the other one)
 *                      0                           (test case #5: s1 and s2 are already anagrams of one another)
 *                      1                           (test case #6: s1=xaxb, s2=bbxx; you must replace 'a' from S1 with 'b' so that S1 = "xbxb")
 *
 */

class Result {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER representing the minimum number of characters to change or -1
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here
        // the string cannot be split into 2 substrings of equal length
        if (s.length()%2 != 0) {
            return -1;
        }

        //the number of characters to change
        int charsToChange = 0;

        String firstString = s.substring(0, s.length()/2);
        String secondString = s.substring(s.length()/2);

        Map<Character, Integer> firstStrCharsFrequencies = new HashMap<>();
        Map<Character, Integer> secondStrCharsFrequencies = new HashMap<>();

        getCharsFrequency(firstString, firstStrCharsFrequencies);

        getCharsFrequency(secondString, secondStrCharsFrequencies);

        for (Map.Entry<Character, Integer> charFrequency : firstStrCharsFrequencies.entrySet()) {
            //if the map with first string characters frequencies contains keys that aren't in the other map
            if (!secondStrCharsFrequencies.containsKey(charFrequency.getKey())) {
                //then add the values corresponding to those keys to the number of characters to change
                charsToChange += charFrequency.getValue();
                //or if both maps contain same key
            } else if (secondStrCharsFrequencies.containsKey(charFrequency.getKey())) {
                //if the key value is greater in the first map
                if (charFrequency.getValue() > secondStrCharsFrequencies.get(charFrequency.getKey())) {
                    //then add the difference to the number of characters to change
                    charsToChange += charFrequency.getValue() - secondStrCharsFrequencies.get(charFrequency.getKey());
                }
            }
        }
        return charsToChange;
    }

    // calculate the characters frequencies of a string
    private static void getCharsFrequency(String str, Map<Character, Integer> stringCharsFrequencies) {
        for (int i=0; i<str.length(); i++) {
            if (stringCharsFrequencies.containsKey(str.charAt(i))) {
                stringCharsFrequencies.put(str.charAt(i), stringCharsFrequencies.get(str.charAt(i))+1);
            } else {
                stringCharsFrequencies.put(str.charAt(i), 1);
            }
        }
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

                    int result = Result.anagram(s);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }