import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2751
// java version "1.8.0_131"

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(arr[i]) + "\n");
        }
        bw.flush();
    }
}