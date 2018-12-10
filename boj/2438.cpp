#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

// https://www.acmicpc.net/problem/2438
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    int N;
    scanf("%d", &N);

    for(int i=1; i<=N; i++) {
        for(int j=0; j<i; j++) {
            printf("*");
        }
        printf("\n");
    }

    return 0;
}