<?php

/**
 * Task:
 * Given the meal price (base cost of a meal),
 * tip percent (the percentage of the meal price being added as tip),
 * and tax percent (the percentage of the meal price being added as tax) for a meal,
 * find and print the meal's total cost. Round the result to the nearest integer.
 */


/*
 * Complete the 'solve' function below.
 *
 * The function accepts following parameters:
 *  1. DOUBLE meal_cost: the cost of food before tip and tax
 *  2. INTEGER tip_percent: the tip percentage
 *  3. INTEGER tax_percent: the tax percentage
 * The function returns nothing.
 */

function solve($meal_cost, $tip_percent, $tax_percent) {
    // Write your code here
    $tip_percent = ($tip_percent * $meal_cost)/100;
    $tax_percent = ($tax_percent * $meal_cost)/100;
    $total_cost = $meal_cost + $tip_percent + $tax_percent;
    return round($total_cost);
}

$meal_cost = doubleval(trim(fgets(STDIN)));

$tip_percent = intval(trim(fgets(STDIN)));

$tax_percent = intval(trim(fgets(STDIN)));

echo solve($meal_cost, $tip_percent, $tax_percent);
