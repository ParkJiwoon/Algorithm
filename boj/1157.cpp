#include <iostream>
#include <string>

using namespace std;

// https://www.acmicpc.net/problem/1157
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    int arr[26] = { 0 };
    string s;
    int max = 0;
    char answer;

    cin >> s;

    // 문자를 하나씩 비교하여 값 넣기
    for(int i=0; i<s.length(); i++) {
        if(65 <= s[i] && s[i] <= 90)
            arr[s[i] - 65]++;
        else if(97 <= s[i] && s[i] <= 122)
            arr[s[i] - 97]++;
    }

    // 가장 숫자가 큰 문자 찾기
    for(int i=0; i<26; i++) {
        if(arr[i] > max) {
            answer = i + 65;
            max = arr[i];
        } else if(arr[i] == max) {
            answer = '?';
        }
    }

    cout << answer;
}