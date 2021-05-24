import java.util.*;

/**
 * 2 types of queries will be performed on a list:
 * insert y at index x
 * delete the element at index x
 */

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        //the initial number of elements in list l
        int n = scan.nextInt();

        //n integers added to list l
        List<Integer> l = new ArrayList<>();
        for(int i=0; i< l.size(); i++) {
            l.add(scan.nextInt());
        }

        //nr of queries
        int Q = scan.nextInt();
        String qry = scan.nextLine();
        // if the query contains the String "Insert", the value y must be inserted into list l at index x
        if (qry.equals("Insert")) {
            int x = scan.nextInt();
            //the value to be inserted into list l
            int y = scan.nextInt();
            l.add(x, y);
        } else {
            //otherwise the element at index x must be deleted from list l
            l.remove(scan.nextInt());
        }

        //Print the updated list l as a single line of space-separated integers.
        for (Integer nr : l) {
            System.out.print(nr + " ");
        }
    }
}
