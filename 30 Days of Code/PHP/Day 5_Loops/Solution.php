<?php
/**
 * Task:
 * Given an integer n, print its first 10 multiples.
 * Each multiple n x i, should be printed on a new line in the form: n x i = result.
 */

$n = intval(trim(fgets(STDIN)));

for ($i=1; $i<=10; $i++) {
    echo sprintf("%d x %d = %d\n", $n, $i, $n * $i);
}
