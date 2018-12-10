#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

// https://www.acmicpc.net/problem/8393
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    int n;
    scanf("%d", &n);

    int sum = 0;

    for(int i=1; i<=n; i++) {
        sum += i;
    }

    printf("%d", sum);

    return 0;
}