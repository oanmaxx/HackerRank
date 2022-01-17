import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * A space explorer's ship crashed on Mars sends a series of SOS messages to Earth for help.
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission.
 * Given the signal received by Earth as a string, s, determine how many letters of the SOS message have been changed by radiation.
 * Example:
 *      INPUT:      SOSSPSSQSSOR
 *      OUTPUT:     3
 */

class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER: the number of letters changed during transmission.
     * The function accepts STRING s as parameter: the string as received on Earth.
     */

    public static int marsExploration(String s) {
        // Write your code here
        int index = 0;
        int countChangedLetters = 0;
        for (char letter : s.toCharArray()) {
            if (index % 3 == 1) {
                countChangedLetters += (letter != 'O') ? 1 : 0;
            } else {
                countChangedLetters += (letter != 'S') ? 1 : 0;
            }
            index++;
        }
        return countChangedLetters;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
