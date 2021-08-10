import java.io.*;

/**
 * task: Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 * example:
 *          INPUT:  s = '12:01:00PM'
 *          OUTPUT: s = '12:01:00'
 *          INPUT:  s = '12:01:00AM'
 *          OUTPUT: s = '00:01:00'
 */

class Result {

    /*
     * Complete the 'timeConversion' function below.
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        //SOLUTION 1
        //parse the first 2 digits to a number
        //if the number is 12, set it to 0(by using modulo 12)
        int hour = Integer.parseInt(s.substring(0, 2)) % 12;
        //if the input string ends with PM, add 12
        if (s.endsWith("PM")) {
            hour += 12;
        }
        //rebuild string: replace first 2 digits with new number and remove AM/PM
        return String.format("%02d", hour) + s.substring(2,8);
        //SOLUTION 2

//        String[] timeArr = s.split(":");
//        String hour = timeArr[0];
//        String minutes = timeArr[1];
//        String seconds = timeArr[2].substring(0,2);
//        String caser = timeArr[2].substring(2,4);

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
