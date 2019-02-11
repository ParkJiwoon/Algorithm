import java.io.*;

// https://www.acmicpc.net/problem/2438
// 빠른 출력을 위해 StringBuilder를 사용해보았다.

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++)
                sb.append("*");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}