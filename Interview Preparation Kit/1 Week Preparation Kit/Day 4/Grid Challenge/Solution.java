import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending.
 * Determine if the columns are also in ascending alphabetical order, top to bottom.
 * Return YES if they are or NO if they are not.
 * Example:
 *  INPUT:
 *        grid = ['abc', 'ade', 'efg']
 *                                          *grid ilustrated    a b c               The rows are already in alphabetical order.
 *                                                              a d e               The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES.
 *                                                              e f g               Only elements within the same row can be rearranged.
 *                                                                                  They cannot be moved to a different row.
 * OUTPUT:
 *       YES
 */

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for (String row : grid) {
            char[] temp = row.toCharArray();
            Arrays.sort(temp);
            grid.set(grid.indexOf(row), Arrays.toString(temp));
        }
        return checkAscendCharsColumn(grid) ? "YES" : "NO";
    }

    private static boolean checkAscendCharsColumn(List<String> gridMatrix) {
        int stringSize = gridMatrix.get(0).length();
        for (int i = 0; i < stringSize; i++) {   //row
            for (int j = 1; j < gridMatrix.size(); j++) {   //column
                if (gridMatrix.get(j).charAt(i) < gridMatrix.get(j-1).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

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
