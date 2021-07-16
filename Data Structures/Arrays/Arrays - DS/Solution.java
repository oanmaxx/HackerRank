import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here

        //solution 1
        Collections.reverse(a);
        return a;

        //solution 2
        //convert the list into array of integers
//        Integer[] arr = a.toArray(new Integer[0]);
//        int arrayLength = arr.length;
//        //iterate through array
//        for (int index=0; index<arrayLength/2; index++) {
//            //swap the elements as follows: arr[0] with arr[n-1], arr[1] with arr[n-1-1] and so on
//            int temp = arr[index];
//            arr[index] = arr[arrayLength-index-1];
//            arr[arrayLength-index-1] = temp;
//        }
//        return Arrays.asList(arr);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> res = Result.reverseArray(arr);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
