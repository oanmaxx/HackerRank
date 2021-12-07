<?php

/**
 * Task:
 * 1. Declare 3 variables: one of type int, one of type double, and one of type String.
 * 2. Read 3 lines of input from stdin and initialize your 3 variables.
 * 3. Use the + operator to perform the following operations:
 *      - print the sum of i plus your int variable on a new line.
 *      - print the sum of d plus your double variable to a scale of one decimal place on a new line.
 *      - concatenate s with the string you read as input and print the result on a new line.
 */
$handle = fopen ("php://stdin","r");
$i = 4;
$d = 4.0;
$s = "HackerRank ";
// Declare second integer, double, and String variables.
$i2 = 0;
$d2 = 0.0;
$s2 = "";

// Read and save an integer, double, and String to your variables.
$i2 = (int) fgets($handle);
$d2 = (float) fgets($handle);
$s2 = fgets($handle);

// Print the sum of both integer variables on a new line.
echo $i + $i2 . "\n";

// Print the sum of the double variables on a new line.
printf("%.01f\n", ($d + $d2));

// Concatenate and print the String variables on a new line
// The 's' variable above should be printed first.
echo $s . $s2 . "\n";

fclose($handle);
?>