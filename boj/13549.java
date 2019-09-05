import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13549

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        if(N >= K)
            System.out.println(N-K);
        else
            System.out.println(BFS(N, K));
    }

    static int BFS(int N, int K) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] subin = new int[100001];
        Arrays.fill(subin, -1);

        q.add(N);
        subin[N] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            // 동생을 만나면 끝
            if(now == K)
                return subin[now];

            // *2 인 거리 중 방문하지 않은 곳 전부 체크
            int temp = now * 2;
            while(temp <= 100000 && subin[temp] == -1) {
                subin[temp] = subin[now];
                q.add(temp);
                temp *= 2;
            }

            for(int i=0; i<2; i++) {
                int next;
                
                if(i == 0)
                    next = now - 1;
                else
                    next = now + 1;

                if(0 <= next && next <= 100000) {
                    if(subin[next] == -1) {
                        q.add(next);
                        subin[next] = subin[now] + 1;
                    }
                }
            }
        }

        return 0;
    }
}