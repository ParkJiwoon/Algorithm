import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2470

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int pick1 = -1;
    static int pick2 = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = stoi(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = stoi(st.nextToken());

        Arrays.sort(arr);

        solution(n, arr);

        System.out.println(pick1 + " " + pick2);
    }

    static void solution(int n, int[] arr) {
        int left = 0;
        int right = n-1;
        int max = 2000000000;

        while(left < right) {
            int absSum = Math.abs(arr[left] + arr[right]);

            // 두 용액 갱신
            if(absSum < max) {
                pick1 = arr[left];
                pick2 = arr[right];
                max = absSum;
            }

            if(Math.abs(arr[left]) < Math.abs(arr[right]))
                right--;
            else
                left++;
        }
    }
}