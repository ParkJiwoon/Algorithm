#include <iostream>

using namespace std;

// https://www.acmicpc.net/problem/2742
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    int N;
    cin >> N;

    while(N--) {
        cout << N+1 << '\n';
    }

	return 0;
}