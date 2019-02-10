import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10835

class Main {
    static int stoi(String s) { return Integer.parseInt(s);}

    static int n;
    static int[] left;
    static int[] right;
    static boolean[][] visited;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        left = new int[n];
        right = new int[n];
        visited = new boolean[n][n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            left[i] = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            right[i] = stoi(st.nextToken());

        sol(0, 0, 0);

        System.out.println(max);
    }

    static void sol(int l, int r, int score) {
        // 카드 전부 소비
        if(l == n || r == n) {
            if(max < score)
                max = score;
            return;
        }

        // 중복된 방문 방지
        if(visited[l][r])
            return;

        visited[l][r] = true;
        
        sol(l+1, r+1, score);
        sol(l+1, r, score);

        // 경우의 수를 나눠서 재귀 방문
        if(left[l] > right[r])
            sol(l, r+1, score + right[r]);
    }
}