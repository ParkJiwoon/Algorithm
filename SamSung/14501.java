import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/14501

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] dp = new int[N+2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp ����
        for(int i=N; i>0; i--) {
            int day = i + T[i];     // i��° ���� ���Ⱓ

            if(day <= N+1) 
                dp[i] = Math.max(P[i] + dp[day], dp[i+1]);
            else
                // ����� �ʰ�
                dp[i] = dp[i+1];
        }

         System.out.println(dp[1]);
    }
}