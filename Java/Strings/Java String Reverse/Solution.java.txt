import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String strReverse = "";
        int strLength = A.length();
        
        for(int i=strLength-1; i>=0; i--) {
            strReverse = strReverse + A.charAt(i);
        }
        
        if(A.equals(strReverse)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}



