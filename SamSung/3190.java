import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3190

class Main {
    static int stoi(String s) { return Integer.parseInt(s);}

    static class Dot {
        int x, y;
        
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int K;
    static int[][] map;
    static int L;
    static int[] time;
    static int[] dir;
    static int[] dx = {-1, 0, 1, 0};    // �ϵ�����
    static int[] dy = {0, 1, 0, -1};
    static Deque<Dot> snake = new ArrayDeque<Dot>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = stoi(br.readLine());
        K = stoi(br.readLine());
        map = new int[n+1][n+1];    // �� �� �� ������ (1,1)

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());
            map[v1][v2] = 1;    // ��� ��ġ�� 1
        }

        L = stoi(br.readLine());
        time = new int[L];
        dir = new int[L];

        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = stoi(st.nextToken());
            dir[i] = getDirection(st.nextToken());
        }

        // ���� Ǯ��
        solution();
    }

    static void solution() {
        int second = 0;
        int snakeDir = 1;    // ù ������ ������
        int timeIdx = 0;
        map[1][1] = 2;  // ó�� ���� ��ġ�� (1,1)
        snake.add(new Dot(1, 1));

        while(true) {
            // �ð��� ������ ���� �ٲٱ�
            if(timeIdx < L && time[timeIdx] == second) {
                snakeDir = (snakeDir + dir[timeIdx])%4;
                timeIdx++;
            }

            // 1. �����̸� �÷� �Ӹ��� ���� ĭ�� ��ġ��Ų��
            int nx = snake.getFirst().x + dx[snakeDir];
            int ny = snake.getFirst().y + dy[snakeDir];

            // ���̳� ���� �ε����� ���� ��
            if(nx <= 0 || nx > n || ny <= 0 || ny > n) {
                System.out.println(second + 1);
                break;
            }
            if(map[nx][ny] == 2) {
                System.out.println(second + 1);
                break;
            }        

            // 2. ���� �̵��� ĭ�� ����� �ִٸ�, ��� �������� ���� �״�� �Ӹ� �߰�
            if(map[nx][ny] == 1) {
                map[nx][ny] = 2;
                snake.addFirst(new Dot(nx, ny));
            }
            // 3. ���� �̵��� ĭ�� ����� ���ٸ�, �����̸� �ٿ� ������ ��ġ�� ĭ ����
            else if(map[nx][ny] == 0) {
                map[nx][ny] = 2;
                snake.addFirst(new Dot(nx, ny));

                Dot tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }

            second++;
        }
    }
    
    // �������� 1 ������ 3
    static int getDirection(String s) {
        if(s.equals("D")) 
            return 1;
        else
            return 3;
    }
}