import java.io.*;
import java.util.*;
 
// https://www.acmicpc.net/problem/2309
 
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        combination(arr, visited, 0, n, 7);
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            if(sum(arr, visited, n) == 100)
                print(arr, visited, n);
            return;
        } else {
            for(int i=start; i<n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    static int sum(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
                sum += arr[i];
        }
        return sum;
    }
 
    static void print(int[] arr, boolean[] visited, int n) {
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
                System.out.println(arr[i]);
        }
    }
}