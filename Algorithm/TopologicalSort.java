import java.util.*;

/**
 * ���� ���� 
 * ���� : DAG(Directed Acyclic Graph, ���⼺�� ������ ����Ŭ�� ���� �׷���)
 * ���� ���� 1 : https://www.acmicpc.net/problem/2252
 * ���� ���� 2 : https://www.acmicpc.net/problem/1766
 */

public class TopologicalSort {
    static int n;
    static int e;
    public static void main(String[] args) {
        n = 7; // ���� ����
        e = 9; // ���� ����
        int[] indegree = new int[n+1];
        List<List<Integer>> array = new ArrayList<List<Integer>>();

        for(int i=0; i<n+1; i++) 
            array.add(new ArrayList<Integer>());
        
        // ���� ��� v1 -> v2
        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};

        /**
         * 1. v1 -> v2 ��������Ʈ ����
         * 2. v2 �� ����Ű�� ��� ���� indegree ����
         */
        for(int i=0; i<e; i++) {
            int c1 = v1[i];
            int c2 = v2[i];

            array.get(c1).add(c2);
            indegree[c2]++;
        }

        topologicalSort(indegree, array);
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> array) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        // ť�� indegree �� 0 �� ��� ���
        for(int i=1; i<n+1; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        /**
         * 1. ť���� ���� ������ �ش� ��尡 ����Ű�� ����� indegree �� 1 ����
         * 2. ���� indegree�� 0 �� �ȴٸ� ť�� �ֱ�
         * 3. ť�� �������� �ݺ�
         */
        while(!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for(Integer i : array.get(node)) {
                indegree[i]--;

                if(indegree[i] == 0)
                    q.offer(i);
            }
        }

        System.out.println(result);            
    }
}