import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2750
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

        bubbleSort(arr, N);

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(arr[i]) + "\n");
        }
        bw.flush();
    }

    /**
     * 이미 정렬이 완료되었으면 더 볼 필요 없으므로 change 변수 사용
     * for i 문 한번 돌 때마다 마지막 원소는 볼 필요 없으므로 j 의 범위를 n-1-i 까지 봄
     */
    static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean change = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    change = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (change == false)
                return;
        }
    }
}