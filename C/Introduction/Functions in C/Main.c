#include <iostream>
#include <cstdio>
using namespace std;

/*
Add `int max_of_four(int a, int b, int c, int d)` here.
*/
int max_of_four(int v, int x, int y, int z) {
    scanf("%d\n%d\n%d\n%d\n", &v, &x, &y, &z);
    int max=v;
    if(max<x) max=x;
    if(max<y) max=y;
    if(max<z) max=z; 
    return max;
}

int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d", ans);
    
    return 0;
}