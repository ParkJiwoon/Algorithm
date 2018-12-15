import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1427
// java version "1.8.0_131"

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int size = N.length();
        Integer[] arr = new Integer[size];

        for(int i=0; i<size; i++) {
            arr[i] = N.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<size; i++) {
            System.out.print(arr[i]);
        }
    }
}