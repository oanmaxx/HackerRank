<?php
/**
 * Task:
 * Given an integer, n, perform the following conditional actions:
 *      - if n is odd, print Weird;
 *      - if n is even and in the inclusive range of 2 to 5, print Not Weird;
 *      - if n is even and in the inclusive range of 6 to 20, print Weird;
 *      - if n is even and greater than 20, print Not Weird.
 * Complete the stub code provided in your editor to print whether n is weird.
 */

$N = intval(trim(fgets(STDIN)));

if ($N>=1 && $N<=100) {
    // if $N is even
    if ($N%2==0) {
        if ($N>=2 && $N<=5) {
            echo "Not Weird";
        } elseif ($N>=6 && $N<=20) {
            echo "Weird";
        } elseif ($N<20) {
            echo "Not Weird";
        }
    } else {
        // if $N is odd
        echo "Weird";
    }
}