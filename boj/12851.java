import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        // 수빈이 위치가 더 크다면 무조건 -1을 반복하는 수밖에 없다.
        if(N >= K) {
            bw.write(N-K + "\n1");
            bw.flush();
            bw.close();
            return;
        }

        int[] time = new int[100001];
        Queue<Integer> q = new LinkedList<Integer>();
        int minTime = 987654321;
        int count = 0;

        q.add(N);
        time[N] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i=0; i<3; i++) {
                int next;

                if(i == 0)
                    next = now + 1;
                else if(i == 1)
                    next = now - 1;
                else
                    next = now * 2;

                if(0 <= next && next <= 100000) {
                    // 수빈이의 다음 이동이 동생과 만날 경우
                    if(next == K) {
                        if(minTime == 987654321)
                            minTime = time[now];
                        
                        if(minTime == time[now])
                            count++;
                    }

                    // minTime이 지나면 최소 시간이 아니기 때문에 더 볼 필요가 없다
                    if(minTime < time[now]){
                        // 출력
                        bw.write(minTime + "\n" + count);
                        bw.flush();
                        bw.close();
                        return;
                    }

                    // 0 이 아니라면 방문했던 곳, 그런데 같은 시간에 방문하는 것은 허용한다.
                    // 같은 시간에 방문한 그곳이 최단거리의 경유지 된다면 그 수만큼 카운트해야되기 때문에
                    if(time[next] != 0 && time[next] != time[now] + 1)
                        continue;

                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }

    }
}