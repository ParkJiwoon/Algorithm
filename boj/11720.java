import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11720
// java version "1.8.0_131"

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();

        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += num.charAt(i) - '0';
        }
        
        System.out.println(sum);
    }
}