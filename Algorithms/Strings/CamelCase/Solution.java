import java.io.*;

/*
 * There is a sequence of words in CamelCase as a string of letters, s, having the following properties:
 *      - It is a concatenation of one or more words consisting of English letters.
 *      - All letters in the first word are lowercase.
 *      - For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
 * Task:
 *      Given s, determine the number of words in s.
 * Examples
 *      INPUT 1:
 *      s = oneTwoThree
 *      OUTPUT 1:
 *      3
 *      INPUT 2:
 *      s = saveChangesInTheEditor
 *      OUTPUT 2:
 *      5
 */

class Result {

    /*
     * Complete the 'camelcase' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int camelcase(String s) {
        // Write your code here
        int wordsInString = 1;
        if (s.isEmpty()) {
            return 0;
        }
        for (char character : s.toCharArray()) {
            if (character>64 && character<91) {
                wordsInString++;
            }
        }
        return wordsInString;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
