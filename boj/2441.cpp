#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

// https://www.acmicpc.net/problem/2441
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++) {
        for(int j=0; j<i; j++)
            printf(" ");
            
        for(int j=0; j<N-i; j++) 
            printf("*");
            
        printf("\n");
    }

    return 0;
}