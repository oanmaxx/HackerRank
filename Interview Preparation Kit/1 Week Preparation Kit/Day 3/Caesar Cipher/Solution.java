import java.io.*;

/**
 *  Caesar's cipher shifts each letter by a number of letters.
 *  If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet.
 *  The cipher only encrypts letters; symbols, such as -, remain unencrypted.
 */

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING:
     *  1. STRING encryptedString - the encrypted string
     * The function accepts following parameters:
     *  1. STRING s - the unencrypted string
     *  2. INTEGER k - the number of letters to rotate the alphabet by
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder encryptedString = new StringBuilder();

        // Update the ASCII values by k and cast to char.
        // If it is a symbol, don't change it.
        for (int i=0; i<s.length(); i++) {
            // capital letter
            if (Character.isUpperCase(s.charAt(i))) {
                encryptedString.append((char) (65 + ((s.charAt(i)+k-65)%26)));
                // lower case letter
            } else if(Character.isLowerCase(s.charAt(i))) {
                encryptedString.append((char) (97 + ((s.charAt(i)+k-97)%26)));
                // symbol, e.g. dash
            } else {
                encryptedString.append((s.charAt(i)));
            }
        }
        return encryptedString.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // the length of the unencrypted string
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
