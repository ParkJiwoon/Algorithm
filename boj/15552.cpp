#include <iostream>
using namespace std;

// https://www.acmicpc.net/problem/15552
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int tc;
	cin >> tc;

	while (tc--)
	{
        int a, b;
		cin >> a >> b;
		cout << a + b << '\n';
	}

	return 0;
}