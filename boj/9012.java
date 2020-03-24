// https://www.acmicpc.net/problem/9012

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            if (isVPS(br.readLine())) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
    }

    static boolean isVPS(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            else {
                if (count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }
}
