#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

// https://www.acmicpc.net/problem/2741
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    int N;
    scanf("%d", &N);

    for(int i=0; i<N; i++) {
        printf("%d\n", i+1);
    }
    return 0;
}