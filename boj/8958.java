import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/8958

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = stoi(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int len = s.length();

            int sum = 0;
            int score = 1;
            /**
             * O 면 더한 후에 score++
             * X 면 더하지 않고 score = 1
             */
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == 'O') {
                    sum += score;
                    score++;
                } else
                    score = 1;
            }

            sb.append(sum + "\n");
        }

        System.out.print(sb);
    }
}