import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * A weighted string is a string of lowercase English letters where each letter has a weight. Character weights are 1 to 26 from a to z(e.g. a:1, b:2, ..., z:26).
 * The weight of a string (or substring) is the sum of the weights of its characters(e.g. apple: 1+16+16+12+5=50, aaa: 1+1+1=3).
 * A uniform string consists of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not.
 * Task:
 *      Given a string, s, let U be the set of weights for all possible uniform contiguous substrings of string s.
 *      There will be n queries to answer where each query consists of a single integer.
 *      For each value in queries, see if it exists in the possible string weights.
 *      Create a return array where for each query, the values is Yes if query[i] is an element of set U. Otherwise, append No.
 *
 * Example
 *      Sample INPUT:
 *                  aaabbbbcccddd               the original string s
 *                  5                           the number of queries (the next n lines contains an integer queries[i]),
 *                  9                           the weight of a uniform substring of s that may or may not exist
 *                  7
 *                  8
 *                  12
 *                  5
 *      Sample OUTPUT:
 *                  Yes
 *                  No
 *                  Yes
 *                  Yes
 *                  No
 */

class Result {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        char[] characters = s.toCharArray();
        Set<Integer> uniformSubstringsWeights = new HashSet<>();
        int substringWeight = 0;
        for (int i = 0; i < characters.length; i++) {
            int charWeight = characters[i] - 'a' + 1;
            substringWeight += charWeight;
            uniformSubstringsWeights.add(substringWeight);
            if (i < characters.length-1 && characters[i+1] != characters[i]) {
                substringWeight = 0;
            }
        }

        List<String> queriesAnswers = new ArrayList<>();
        for (int query : queries) {
            if (uniformSubstringsWeights.contains(query)) {
                queriesAnswers.add("Yes");
            } else {
                queriesAnswers.add("No");
            }
        }
        return queriesAnswers;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
