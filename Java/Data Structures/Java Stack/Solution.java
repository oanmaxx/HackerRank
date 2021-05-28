import java.util.*;

class Solution {

    static boolean balancedStr(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
            }

            if (str.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }

            if (str.charAt(i) == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }

            if (str.charAt(i) == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(balancedStr(input));
        }
    }
}





