
import java.util.Scanner;

class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}
//Write your code here
class MyRegex {
    //write a regular expression that can be used to validate an IP address
    //a string in the form "A.B.C.D",
    // where the value of A, B, C, and D may range from 0 to 255.
    // Leading zeros are allowed.
    // The length of A, B, C, or D can't be greater than 3.
    String pattern =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
