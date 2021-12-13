<?php

/**
 * Task:
 * Write a Person class with an instance variable, age, and a constructor that takes an integer, initialAge, as a parameter.
 * The constructor must assign initialAge to age after confirming the argument passed as initialAge is not negative;
 * if a negative argument is passed as initialAge, the constructor should set age to 0 and print "Age is not valid, setting age to 0.".
 * In addition, you must write the following instance methods:
 *      1. yearPasses() should increase the age instance variable by 1.
 *      2. amIOld() should perform the following conditional actions:
 *          - if age < 13, print "You are young."
 *          - if age >=13 and age <18, print "You are teenager."
 *          - Otherwise, print "You are old."
 */
class Person{
    public $age;

    public function __construct($initialAge){
        // Add some more code to run some checks on initialAge
        if ($initialAge > 0) {
            $this->age = $initialAge;
        } else {
            $this->age = 0;
            echo "Age is not valid, setting age to 0." . "\n";
        }
    }
    public  function amIOld(){
        // Do some computations in here and print out the correct statement to the console
        if ($this->age < 13) {
            echo "You are young." . "\n";
        } elseif ($this->age<18) {
            echo "You are a teenager." . "\n";
        } else {
            echo "You are old." . "\n";
        }
    }
    public  function yearPasses(){
        // Increment the age of the person in here
        $this->age++;
    }
}

$T = intval(fgets(STDIN));
for($i=0;$i<$T;$i++){
    $age=intval(fgets(STDIN));
    $p=new Person($age);
    $p->amIOld();
    for($j=0;$j<3;$j++){
        $p->yearPasses();
    }
    $p->amIOld();
    echo "\n";

}
?>