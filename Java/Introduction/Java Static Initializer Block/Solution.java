import java.util.*;

/**
 * static initialization block
 * complete the given code so that it outputs the area of a parallelogram with breadth B and height H.
 * you should read the variables from the standard input.
 * if B<=0 or H<=0, the output should be "java.lang.Exception: Breadth and height must be positive".
 */

public class Solution {
    //Write your code here
    static Scanner scanner = new Scanner(System.in);
    public static int B = scanner.nextInt();
    public static int H = scanner.nextInt();
    static boolean flag = true;

    static {
        try {
            if (B<=0 || H<=0) {
                flag=false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }
    }
}

