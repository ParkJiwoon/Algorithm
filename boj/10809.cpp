#include <iostream>
#include <string>

using namespace std;

// https://www.acmicpc.net/problem/10809
// gcc version 6.3.0 (MinGW.org GCC-6.3.0-1)

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    string s;
    cin >> s;
    
    for(int i=97; i<=122; i++) {
        char alphabet = (char) i;
        printf("%d ", s.find(alphabet));
    }    
}