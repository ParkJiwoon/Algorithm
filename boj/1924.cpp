#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

// https://www.acmicpc.net/problem/1924
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    int month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    string day[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int x, y;
    int count = 0;

    scanf("%d %d", &x, &y);

    // 월 만큼 다 더하고 일수를 더한다음에 7을 나눈 나머지
    for(int i=1; i<x; i++) {
        count += month[i];
    }

    count += y;

    printf("%s", day[count%7].c_str());    

    return 0;
}