#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

// https://www.acmicpc.net/problem/2739
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    int N;
    scanf("%d", &N);

    for(int i=1; i<=9; i++) {
        printf("%d * %d = %d\n", N, i, N*i);
    }

    return 0;
}