package cretu.oana;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * task:
 * Create a class Prime. The class Prime should contain a single method checkPrime.
 * You should write the checkPrime method in such a way that the code prints only the prime numbers.
 * In case there is no prime number, then a blank line should be printed.
 * Do not use method overloading!
 * Sample INPUT:
 *      2
 *      1
 *      3
 *      4
 *      5
 * Sample OUTPUT:
 *      2
 *      2
 *      2 3
 *      2 3 5
 */

class Prime {
    //varargs feature is used instead of method overloading
    public void checkPrime(int... integers) {
        StringBuilder numbers = new StringBuilder();
        for (int number : integers) {
            boolean prime = true;
            if (number<=3 && number>1) {
                numbers.append(number).append(" ");
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {      //if the number has at least one non-trivial divisor, it is no a prime number
                        prime = false;
                        break;
                    }
                }
                if (prime && number!=1) {
                    numbers.append(number).append(" ");
                }
            }
        }
        System.out.println(numbers);
    }
}

public class Solution {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++) {
                if(set.contains(methods[i].getName())) {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload) {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

