import java.io.*;
import java.math.*;

/**
 * certainty = 10 to achieve 99.9% accuracy.
 * if the result method is "prime", it's only 99.9% certain.
 * it probably just hasn't found a prime number that divides the BigInteger yet.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(bufferedReader.readLine());
        System.out.println(n.isProbablePrime(10) ? "prime" : "not prime");

        bufferedReader.close();
    }
}
