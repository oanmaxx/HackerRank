import java.util.*;

interface AdvancedArithmetic{
    int divisor_sum(int n);
}
//Write your code here

class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        int sum=0;
        if(n>1000) {
            System.out.println("n number cannot be greater than 1000");
        }
        if(n==1) {
            return n;
        }
        for(int i=2; i<=n/2; i++) {
            if(n%i==0) {
                sum+=i;
            }
        }
        return sum+1+n;
    }
}

class Solution {
    public static void main(String []args) {
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o) {
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

