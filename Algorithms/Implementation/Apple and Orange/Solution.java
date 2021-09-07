import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Task:
 * Determine the number of apples and oranges that land on Sam's house.
 * The house is between the start point, s, and the end point, t. The apple tree is to the left of the house, and the orange tree is to its right.
 * Assume the trees are located on a single point, where the apple tree is at point a, and the orange tree is at point b.
 * When a fruit falls from its tree, it lands d units of distance from its tree of origin along the x-axis( a negative value of d means the fruit fell d units to the tree's left,
 * and a positive value of d means it falls d units to the tree's right).
 * Given the value of d for m apples and n oranges, determine how many apples and oranges will fall on Sam's house (i.e., in the inclusive range [s,t])?
 * Print the number of apples and oranges that land on Sam's house, each on a separate line.
 *
 * Sample INPUT:
 *          7 11                s t
 *          5 15                a b
 *          3 2                 m n
 *          -2 2 1              the respective distances that each apples falls from point a
 *          5 -6                the respective distances that each oranges falls from point b
 * Sample OUTPUT:
 *          1                   the number of apples that fall on Sam's house
 *          1                   the number of oranges that fall on Sam's house
 */

class Result {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s - starting point of Sam's house location
     *  2. INTEGER t - ending location of Sam's house location
     *  3. INTEGER a - location of the Apple tree
     *  4. INTEGER b - location of the Orange tree
     *  5. INTEGER_ARRAY apples - distances at which each apple falls from the tree
     *  6. INTEGER_ARRAY oranges - distances at which each orange falls from the tree
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        List<Integer> applesLandingPositions = calcFruitLandingPosition(a, apples);
        List<Integer> orangesLandingPositions = calcFruitLandingPosition(b, oranges);

        System.out.println(countFruitsOnHouse(applesLandingPositions, s, t));
        System.out.println(countFruitsOnHouse(orangesLandingPositions, s, t));
    }

    /**
     * Calculate each fruit landing position by adding the fruit distance to the position of tree.
     * @param treePosition
     * @param unitsDistance represents a fruit units of distance from tree's position.
     * @return a List of Integers with each fruit landing position.
     */
    private static List<Integer> calcFruitLandingPosition(int treePosition, List<Integer> unitsDistance) {
        List<Integer> fruitsLandingPositions = new ArrayList<>();
        for (Integer dUnit : unitsDistance) {
            fruitsLandingPositions.add(treePosition + dUnit);
        }
        return fruitsLandingPositions;
    }

    /**
     * Determine how many fruits land on the house region(the inclusive range between s and t).
     * @param fruitsPositions represents a fruit landing position.
     * @param houseStartPoint
     * @param houseEndPoint
     * @return an integer representing the number of fruits that land on the house.
     */
    private static int countFruitsOnHouse(List<Integer> fruitsPositions, int houseStartPoint, int houseEndPoint) {
        int fruitCounter = 0;
        for (Integer fruitPos : fruitsPositions) {
            if (fruitPos >= houseStartPoint && fruitPos <= houseEndPoint) {
                fruitCounter++;
            }
        }
        return fruitCounter;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
