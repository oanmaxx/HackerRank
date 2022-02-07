import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Task:
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
 * Each person wears a sticker indicating their initial position in the queue from 1 to n.
 * Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker.
 * One person can bribe at most two others.
 * Determine the minimum number of bribes that took place to get to a given queue order.
 * Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
 *
 * Example:
 *      INPUT:  q = [2, 1, 5, 3, 4]
 *      OUTPUT: 3
 *                                  Initial state:                                              1, 2, 3, 4, 5
 *                                  Person 5 moves one position ahead by bribing person 4:      1, 2, 3, 5, 4
 *                                  Person 5 moves another position ahead by bribing person 3:  1, 2, 5, 3, 4
 *                                  Person 2 moves one position ahead by bribing person 1:      2, 1, 5, 3, 4
 *                                  So, the final state is [2, 1, 5, 3, 4] after three bribing operations.
 */

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter: describing the final state of the queue.
     */

    public static void minimumBribes(List<Integer> q) {
        int nrBribes = 0;
        boolean chaotic = false;
        for (int i = q.size()-1; i >= 0; i--) {
            if ((q.get(i)-(i+1)) > 2) {
                chaotic = true;
            }
            int startIndex = Math.max(0, q.get(i)-2);
            for (int j = startIndex; j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    nrBribes++;
                }
            }
        }

        if (chaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(nrBribes);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
