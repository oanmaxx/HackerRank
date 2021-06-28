
import java.util.*;

/**
 * Given 2 BitSets,B1 and B2, of size N where all bits in both BitSets are initialized to 0,
 * perform a series of M operations. After each operation, print the number of set bits
 * in the respective BitSets as two space-separated integers on a new line.
 * For the binary operations AND, OR, and XOR, operands are read from left to right
 * and the BitSet resulting from the operation replaces the contents of the first operand.
 * sample INPUT:
 *      5 4             //N=5 M=4
 *      AND 1 2         //B1 AND B2
 *      SET 1 4         //Set B1[4] to true(1)
 *      FLIP 2 2        //Flip B2[2] from false(0) to true(1)
 *      OR 2 1          //B2 OR B1
 * sample OUTPUT:
 *      0 0             //B1={0, 0, 0, 0, 0}    B2={0, 0, 0, 0, 0}
 *      1 0             //B1={0, 0, 0, 0, 1}    B2={0, 0, 0, 0, 0}
 *      1 1             //B1={0, 0, 0, 0, 1}    B2={0, 0, 1, 0, 0}
 *      1 2             //B1={0, 0, 0, 0, 1}    B2={0, 0, 1, 0, 1}
 */

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();          //the length of both BitSets B1 and B2
        int M = scanner.nextInt();          //number of operations to perform
        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        while (M > 0) {
            String string = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            switch (string) {
                case "AND":
                    if (a == 1) {
                        B1.and(B2);
                    } else {
                        B2.and(B1);
                    }
                    break;
                case "OR":
                    if (a == 1) {
                        B1.or(B2);
                    } else {
                        B2.or(B1);
                    }
                    break;
                case "XOR":
                    if (a == 1) {
                        B1.xor(B2);
                    } else {
                        B2.xor(B1);
                    }
                    break;
                case "FLIP":
                    if (a == 1) {
                        B1.flip(b);
                    } else {
                        B2.flip(b);
                    }
                    break;
                case "SET":
                    if (a == 1) {
                        B1.set(b);
                    } else {
                        B2.set(b);
                    }
                    break;
                default:
                    break;
            }
            M--;
            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
        scanner.close();
    }
}
