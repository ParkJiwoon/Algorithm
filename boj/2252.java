import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2252

class Main {
    static int n;   // ��� ����
    static int m;   // ���� ����

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] indegree = new int[n+1];

        for(int i=0; i<n+1; i++)
            list.add(new ArrayList<Integer>());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            // v1 -> v2
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            indegree[v2]++;
        }

        // Solve
        topologicalSort(indegree, list);
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> list) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        // indegree�� 0 �� ��� Queue �� �ֱ�
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        // q ���� ��带 �ϳ��� ���� ����� ����� indegree ����
        // indegree �� 0 �� �� ���� Queue �� �ֱ�
        while(!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for(Integer linked : list.get(node)) {
                indegree[linked]--;
                
                if(indegree[linked] == 0)
                    q.offer(linked);
            }
        }

        // ��� ���
        while(!result.isEmpty()) {
            System.out.print(result.poll() + " ");
        }
    }
}