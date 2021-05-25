#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    //take a character, a string and a sentence as input
    char ch;
    char s[100];
    char sen[100];
    scanf("%c", &ch);
    scanf("\n");
    scanf("%[^\n]%*c", &s);
    scanf("%[^\n]%*c", &sen);
    //print the character, the string, and the sentence as output
    printf("%c\n%s\n%s\n", ch, s, sen);
    return 0;
}
