import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14501

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) 
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        /**
         * ��� ����
         * total �� long���� �����Ѵ�.
         */
        long total = n;
        for(int i=0; i<n; i++) {
            // �Ѱ������� ������ �Ѹ� �ʿ�
            a[i] -= b;

            // �ΰ��������� ������ ä���
            if(a[i] > 0) {
                total += a[i]/c;

                if(a[i] % c != 0)
                    total++;
            }
        }

        System.out.println(total);
    }
}