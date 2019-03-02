import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1238

class Main {
    static int stoi(String s) { return Integer.parseInt(s);}

    static final int INF = 987654321;
    static int N, M, X;
    static int[][] arr, rev;
    static int[] dist, revDist;

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input data
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        X = stoi(st.nextToken());
        dist = new int[N+1];
        revDist = new int[N+1];
        arr = new int[N+1][N+1];
        rev = new int[N+1][N+1];

        init();

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());

            arr[v1][v2] = rev[v2][v1] = stoi(st.nextToken());
        }

        // solve
        dijkstra(arr, dist, X);
        dijkstra(rev, revDist, X);

        // answer
        int max = -1;
        for(int i=1; i<=N; i++)
            max = Math.max(max, dist[i] + revDist[i]);
        System.out.println(max);
    }

    static void init() {
        for(int i=1; i<=N; i++) {
            dist[i] = revDist[i] = INF;

            for(int j=1; j<=N; j++)
                arr[i][j] = rev[i][j] = INF;
        }
    }

    static void dijkstra(int[][] edge, int[] distance, int start) {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            int idx = pq.poll().index;

            if(visited[idx]) continue;
            visited[idx] = true;

            for(int i=1; i<=N; i++) {
                if(distance[i] > distance[idx] + edge[idx][i]) {
                    distance[i] = distance[idx] + edge[idx][i];
                    pq.add(new Node(i, distance[i]));
                }
            }
        }
    }
}