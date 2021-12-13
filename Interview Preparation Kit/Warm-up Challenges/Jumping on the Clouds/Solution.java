import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Task:
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
 * The player must avoid the thunderheads.
 * Determine the minimum number of jumps it will take to jump from the starting position to the last cloud.
 * It is always possible to win the game.
 * For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 * Example:
 *      INPUT:          0 1 0 0 0 1 0
 *      OUTPUT:         3
 *      EXPLANATION:    Index the array from 0...6. The number on each cloud is its index in the list
 *                      so the player must avoid the clouds at indices 1 and 5. They could follow these two paths:
 *                      0->2->4->6 or 0->2->3->4->6. The first path takes 3 jumps while the second takes 4. Return 3.
 */

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER: the minimum number of jumps required.
     * The function accepts INTEGER_ARRAY c as parameter: an array of binary integers.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int nrJumps = -1;
        while (!c.isEmpty()) {
            // if there are more than 2 clouds in the list and the cloud with index=2 is a safe cloud(its value is 0), you can jump 2 clouds(delete the first 2 clouds)
            if (c.size() > 2 && c.get(2)==0) {
                c.remove(0);
                c.remove(0);
            } else {
                // you can jump only one cloud(delete first cloud)
                c.remove(0);
            }
            nrJumps ++;
        }
        return nrJumps;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
