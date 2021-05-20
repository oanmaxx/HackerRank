import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * convert an amount of money into different currency formats
 */

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat formattedPaymentUsa = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat formattedPaymentIndia = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat formattedPaymentChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat formattedPaymentFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        String us = formattedPaymentUsa.format(payment);
        String india =formattedPaymentIndia.format(payment);
        String china = formattedPaymentChina.format(payment);
        String france = formattedPaymentFrance.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
