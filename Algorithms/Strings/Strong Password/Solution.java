import java.io.*;
import java.util.regex.Pattern;

/*
 * Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password.
 * However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:
 *      - Its length is at least 6.
 *      - It contains at least one digit.
 *      - It contains at least one lowercase English character.
 *      - It contains at least one uppercase English character.
 *      - It contains at least one special character. The special characters are: !@#$%^&*()-+
 *  She typed a random string of length  in the password field but wasn't sure if it was strong.
 *  Given the string she typed, can you find the minimum number of characters she must add to make her password strong?
 *
 * Examples:
 *      INPUT 1:    2bbbb       this password is 5 characters long and is missing an uppercase and a special character.
 *      OUTPUT 1:   2           the minimum number of characters to add
 *      INPUT 2:    2bb#A       this password is 5 characters long and has at least one of each character type
 *      OUTPUT 2:   1           the minimum number of characters to add
 */

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n = the length of the password
     *  2. STRING password = the password to test
     * Returns an int = the minimum number of characters to make the password strong
     */

    public static int minimumNumber(int n, String password) {
        // The number of parameters to check: uppercase, lowercase, digit, special character
        int countParamToCheck = 4;
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern lowercase = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern specialChar = Pattern.compile("[!@#$%^&*()+-]");

        if (uppercase.matcher(password).find()) {
            countParamToCheck--;
        }
        if (lowercase.matcher(password).find()) {
            countParamToCheck--;
        }
        if (digit.matcher(password).find()) {
            countParamToCheck--;
        }
        if (specialChar.matcher(password).find()) {
            countParamToCheck--;
        }
        return Math.max(countParamToCheck, 6-n);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
