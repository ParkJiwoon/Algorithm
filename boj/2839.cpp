#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

// https://www.acmicpc.net/problem/2839
// Thread model: win32
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    int N;
    int kg[5001];

    scanf("%d", &N);

    // 3kg과 5kg은 무조건 1개
    kg[3] = 1;
    kg[5] = 1;

    // N의 최대값인 5000까지 돌면서 봉지 갯수를 저장한다.
    // 현재 i 일때의 봉지수는 i-5 일때에서 5kg 짜리 하나를 추가한거
    // 또는 i-3 일때에서 3kg 짜리 하나 추가한 거
    for(int i=6; i<5001; i++) {
        if(kg[i-5] > 0 && kg[i-3] > 0) {
            kg[i] = min(kg[i-3] + 1, kg[i-5] + 1);
        } 
        else if(kg[i-3] > 0) {
            kg[i] = kg[i-3] + 1;
        }
        else if(kg[i-5] > 0) {
            kg[i] = kg[i-5] + 1;
        }
    }

    if(kg[N] == 0) {
        printf("-1");
    } else {
        printf("%d", kg[N]);
    }
    return 0;
}