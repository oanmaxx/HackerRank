import java.util.*;

/**
 * playing a game on an array:
 * you can move from index i to index i+1, i-1, or i+leap
 * as long as the destination index is a cell containing a 0.
 * if the destination index is greater than n-1, you win the game.
 */

public class Solution {

    public static boolean canWin(int leap, int[] game, int i) {
        //return true if you can win the game; otherwise, return false.
        //0<=i<n & destination index it's a cell containing a 0
        if (i<0 || game[i]==1) {
            return false;
        }
        if (i+1 >= game.length || i+leap >= game.length) {
            return true;
        }

        //flag
        game[i]=1;
        return canWin(leap, game, i+leap)
                || canWin(leap, game, i+1)
                || canWin(leap, game, i-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();         //nr of queries
        while (q-- > 0) {
            int n = scan.nextInt();     //nr of array's elements
            int leap = scan.nextInt();  //the size of the leap

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }
}