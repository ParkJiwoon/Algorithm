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
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(arr, N);

        for(int i=0; i<N; i++) {
            bw.write(String.valueOf(arr[i]) + "\n");
        }
        bw.flush();
    }

    static void bubbleSort(int[] arr, int N) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}