#include <iostream>

using namespace std;

// https://www.acmicpc.net/problem/8958
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int tc;
    cin >> tc;

    while(tc--) {
        string s;
        cin >> s;

        int score[s.length()] = {0};
        int sum = 0;

        for(int i=0; i<s.length(); i++) {
            if(s[i] == 'O') {
                if(i == 0)
                    score[i] = 1;
                else
                    score[i] = score[i-1] + 1;
            }
            sum += score[i];
        }

        cout << sum << '\n';
    }

    return 0;
}