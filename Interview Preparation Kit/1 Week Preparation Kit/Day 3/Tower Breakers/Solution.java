import java.io.*;
import java.util.stream.*;

/**
 * Task:
 * Two players are playing a game of Tower Breakers! The rules of the game are as follows:
 *      - player 1 always moves first.
 *      - initially there are n towers.
 *      - each tower is of height m.
 *      - the players move in alternating turns.
 *      - in each turn, a player can choose a tower of height x and reduce its height to y, where 1<=y<x and y evenly divides x.
 *      - if the current player is unable to make a move, they lose the game.
 * Given the values of n and m, determine which player will win. If the first player wins, return 1. Otherwise, return 2.
 */

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER: the winner of the game.
     * The function accepts following parameters:
     *  1. INTEGER n: the number of towers
     *  2. INTEGER m: the height of each tower
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        return (m != 1 && n % 2 == 1) ? 1 : 2;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

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
