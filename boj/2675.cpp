#include <iostream>
#include <string>

using namespace std;

// https://www.acmicpc.net/problem/2675
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    int tc;
    cin >> tc;

    while(tc--) {
        int r;
        string s;

        cin >> r >> s;

        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<r; j++) {
                cout << s[i];
            }
        }

        cout << '\n';
    }
}