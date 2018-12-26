import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/1182
 
class Main {
    static int count = 0;
    static int s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        powerSet(arr, n, 0, 0);        
        // s�� 0 �϶��� �κ����� �߿� �������� ��쵵 ī��Ʈ �� �� ����
        if(s == 0)
            count--;
        System.out.println(count);
    }

    static void powerSet(int[] arr, int n, int idx, int sum) {
        if(idx == n) {
            if(sum == s)
                count++;
            return;
        }

        powerSet(arr, n, idx + 1, sum);
        powerSet(arr, n, idx + 1, sum + arr[idx]);
    }
}