import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15953

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(get2017(a) + get2018(b));
        }
    }

    static int get2017(int a) {
        if (a == 0)
            return 0;
        else if (a == 1)
            return 500 * 10000;
        else if (a <= 3)
            return 300 * 10000;
        else if (a <= 6)
            return 200 * 10000;
        else if (a <= 10)
            return 50 * 10000;
        else if (a <= 15)
            return 30 * 10000;
        else if (a <= 21)
            return 10 * 10000;
        else
            return 0;
    }

    static int get2018(int b) {
        if (b == 0)
            return 0;
        else if (b == 1)
            return 512 * 10000;
        else if (b <= 3)
            return 256 * 10000;
        else if (b <= 7)
            return 128 * 10000;
        else if (b <= 15)
            return 64 * 10000;
        else if (b <= 31)
            return 32 * 10000;
        else
            return 0;
    }
}