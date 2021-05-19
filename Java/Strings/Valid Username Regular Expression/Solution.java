import java.util.Scanner;

//the username is considered valid if all the following constraints are satisfied:
//- the username consists of 8 to 30 characters inclusive
//- the username can only contain alphanumeric characters and underscores
//- the first character of the username must be an alphabetic character, either lowercase or uppercase

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "^[a-zA-Z]\\w{7,29}";
}

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}