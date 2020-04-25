import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/6118

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int index, distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        List<Integer>[] nodes = new ArrayList[N+1];

        for(int i=0; i<N+1; i++) {
            nodes[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());

            nodes[v1].add(v2);
            nodes[v2].add(v1);
        }

        // 나중에 출력할 3개
        int number = 2;
        int maxDistance = -1;
        int count = 1;

        // BFS 시작
        Queue<Node> q = new LinkedList<Node>();
        boolean[] visited = new boolean[N+1];

        q.add(new Node(1, 0));
        visited[1] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(maxDistance < now.distance) {
                maxDistance = now.distance;
                number = now.index;
                count = 1;
            }
            // 최대거리가 같은 애들은 카운트해줌
            else if(maxDistance == now.distance) {
                count++;

                // 가장 작은 헛간으로 갱신
                if(number > now.index)
                    number = now.index;
            }

            for(Integer next : nodes[now.index]) {
                if(visited[next])
                    continue;
                
                q.add(new Node(next, now.distance+1));
                visited[next] = true;
            }
        }

        // 출력
        bw.write(number + " " + maxDistance + " " + count);
        bw.flush();
        bw.close();
    }
}