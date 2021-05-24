import java.util.*;

/**
 * You are given n lines. In each line there are zero or more integers.
 * You need to answer a few queries where you need to tell the number located in yth position of xth line.
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //a list of lines
        List<List<Integer>> lines = new ArrayList<>();
        //n = nr of lines
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            //the container(a list) => the line
            List<Integer> line = new ArrayList<>();
            //nr of integers on current line
            int d = in.nextInt();
            //add the integers on a line
            for (int j = 0; j < d; j++) {
                line.add(in.nextInt());
            }
            //add the line to the list of lines
            lines.add(line);
        }

        //q = nr of queries
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            //xth line
            int x = in.nextInt();
            //yth position
            int y = in.nextInt();
            //there is no such position
            if (y > lines.get(x - 1).size()) {
                System.out.println("ERROR!");
            } else {
                //the number located in yth position of xth line
                System.out.println(lines.get(x - 1).get(y - 1));
            }
        }

        in.close();
    }
}
