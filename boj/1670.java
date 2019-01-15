import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1670

class Main {
    static int stoi(String s) { return Integer.parseInt(s); }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());
        long[] dp = new long[n+1];
        long div = 987654321;

        dp[0] = 1;
        dp[2] = 1;
        // dp[4] += dp[2] * dp[0]
        // dp[4] += dp[2] * dp[0];
        
        // dp[6] += dp[4] * dp[0];
        // dp[6] += dp[2] * dp[2];
        // dp[6] += dp[0] * dp[4];

        /**
         * 점 하나를 기준으로 다른 점과 하나씩 연결 한 후에 갈라진 점의 경우의 수를 세서 곱한다
         * 주의할 점은 점은 항상 짝수개씩 갈라져야 하기 때문에 2씩 증가해야한다.
         */
        for(int i=4; i<=n; i += 2) {
            for(int j=0; j<=i-2; j += 2) {
                dp[i] += dp[j] * dp[i-j-2];
                dp[i] %= div;
            }
        }

        System.out.println(dp[n]);
    }
}