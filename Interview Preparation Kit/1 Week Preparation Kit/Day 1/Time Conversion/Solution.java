import java.io.*;

/**
 * Task:
 * Given a time in 12-hour AM/PM format, convert it to military(24-hour) time.
 * Note: 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 *       12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 */

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING: the military time.
     * The function accepts STRING s as parameter: 12-hour AM/PM format.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String[] time = s.split(":");
        String militaryTime = "";

        String hour = time[0];
        String minutes = time[1];
        String seconds = time[2].substring(0,2);
        String momentOfDay = time[2].substring(2,4);

        // if input string ends with PM, then add 12 to hour substring
        if (momentOfDay.equals("PM")) {
            militaryTime = ((Integer.parseInt(hour) % 12) + 12) + ":" + minutes + ":" + seconds;
        }

        // if input string ends with AM and hour=12, then hour=00, else hour remains the same
        if (momentOfDay.equals("AM")) {
            if (hour.equals("12")) {
                militaryTime = "00" + ":" + minutes + ":" + seconds;
            } else {
                militaryTime = String.format("%02d", Integer.parseInt(hour)) + ":" + minutes + ":" + seconds;
            }
        }
        return militaryTime;
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
