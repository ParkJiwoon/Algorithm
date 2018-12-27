import java.io.*;

// https://www.acmicpc.net/problem/1436

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 0;

        while(N > 0) {
            num++;
            String str = Integer.toString(num);   // int to string ����ȯ

            if(str.contains("666")) 
                N--;
        }

        System.out.println(num);
    }
}