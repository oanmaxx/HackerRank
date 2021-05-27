#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
	//declare variables: two of type int and two of type float
    int a=0, b=0, intSum=0, intDiff=0;
    float n=0, m=0, floatSum=0, floatDiff=0;
    //read the input data from the console
    scanf("%d %d", &a, &b);
    scanf("%f %f", &n, &m);
    intSum=a+b;
    intDiff=a-b;
    floatSum=n+m;
    floatDiff=n-m;
    //sum and difference of two integer numbers
    printf("%d %d\n", intSum, intDiff);
    //sum and difference of two float numbers
    printf("%.1f %.1f", floatSum, floatDiff);
    
    return 0;
}
