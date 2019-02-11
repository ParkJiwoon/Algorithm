import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14890

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int n;
    static int L;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        L = stoi(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = stoi(st.nextToken());
        }

        // Ǯ�� ����
        for (int i = 0; i < n; i++) {
            if (canGo(i, 0, 0))
                count++;

            if (canGo(0, i, 1))
                count++;
        }

        System.out.println(count);
    }

    // �� ���� �������� Ȯ�� d = 0 �̸� ��˻�, d = 1 �̸� ���˻�
    static boolean canGo(int x, int y, int d) {
        int[] height = new int[n];
        boolean[] visited = new boolean[n];     // ���ΰ� �̹� �����ִ��� üũ

        // �˾ƺ��� ���� height �迭�� �ű��
        for (int i = 0; i < n; i++) {
            if (d == 0)
                height[i] = map[x][y + i];
            else
                height[i] = map[x + i][y];
        }

        for (int i = 0; i < n - 1; i++) {
            // ���̰� ������ �н�
            if (height[i] == height[i + 1])
                continue;

            if (Math.abs(height[i] - height[i + 1]) > 1)
                return false;

            // �������ߵǴ� ���
            if (height[i] - 1 == height[i + 1]) {
                for (int j = i + 1; j <= i + L; j++) {
                    // j�� ������ ����ų� ���̰� �ٸ��ų� �̹� ���ΰ� �ִ� ���
                    if (j >= n || height[i + 1] != height[j] || visited[j] == true)
                        return false;
                    visited[j] = true;
                }
            }
            // �ö󰡾ߵǴ� ���
            else if (height[i] + 1 == height[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j] == true)
                        return false;
                    visited[j] = true;
                }
            }
        }

        return true;
    }
}