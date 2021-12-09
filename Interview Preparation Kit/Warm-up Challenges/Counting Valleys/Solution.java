import java.io.*;

/**
 * Task:
 * Find and print the number of valleys walked through by a hiker.
 * A hike takes exactly "steps" steps, for every step it was noted if it was an uphill, U, or a downhill, D step.
 * Hikes always start and end at sea level, and each step up or down represents a 1 unit change in altitude.
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Example:
 *      INPUT:          8           //steps
 *                      DDUUUUDD    //path
 *     OUTPUT:          1           //valley
 *     EXPLANATION:     The hiker first enters a valley 2 units deep.
 *                      Then he climbs out and up onto a mountain 2 units high.
 *                      Finally, the hiker returns to sea level and ends the hike.
 */

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps: the number of steps on the hike
     *  2. STRING path: a string describing the path
     * The function returns:
     *  1. INTEGER nrOfValleys: the number of valleys traversed
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int nrOfValleys = 0;
        int level = 0, prevLevel = 0;

        for (char step : path.toCharArray()) {
            if (step == 'U') {
                level++;
            } else {
                level--;
            }
            // if the hiker reached sea level(level==0) and the previous level was bellow sea level(prevLevel<0)
            if(level==0 && prevLevel < 0) {
                // the hiker walked through a valley
                nrOfValleys++;
            }
            prevLevel = level;
        }
        return nrOfValleys;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
