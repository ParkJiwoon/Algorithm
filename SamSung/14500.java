import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14500

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int stoi(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) 
                map[i][j] = stoi(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
                another(i, j);
            }
        }

        System.out.println(max);
    }

    // dfs�� ���̰� �ִ� 4�� ��찡 ��Ʈ�ι̳�, �� �� ����� ����
    static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            if(max < sum) 
                max = sum;
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                if(visited[nx][ny] != true) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    // �� ����� ã�´�. ��� �ִ� ��ǥ�� �������� �� ������ Ž���Ѵ�.
    static void another(int x, int y) {
        // 1. ���� �������϶��� �� ��� �Ұ���
        if((x == 0 || x == n-1) && (y == 0 || y == m-1)) return;
        
        int sum = map[x][y];

        // 2. ���� �׵θ��϶��� ����� �ϳ�
        if(x == 0)
            sum += map[x][y-1] + map[x][y+1] + map[x+1][y];
        else if(x == n-1)
            sum += map[x][y-1] + map[x][y+1] + map[x-1][y];
        else if(y == 0)
            sum += map[x-1][y] + map[x+1][y] + map[x][y+1];
        else if(y == m-1) 
            sum += map[x-1][y] + map[x+1][y] + map[x][y-1];
        // 3. ���� �׵θ��� �ƴ� ���� 4 ���� ����� ��
        else {
            sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x][y-1] + map[x][y+1]);
            sum = Math.max(sum, map[x][y] + map[x-1][y] + map[x][y-1] + map[x][y+1]);
            sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x-1][y] + map[x+1][y]);
            sum = Math.max(sum, map[x][y] + map[x][y-1] + map[x-1][y] + map[x+1][y]);
        }

        max = Math.max(max, sum);        
    }
}