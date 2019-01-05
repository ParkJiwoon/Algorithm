import java.io.*;
import java.util.*;

// 연습 문제 : https://www.acmicpc.net/problem/15552

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input intger 1. 
        // ex) 1
        int a = Integer.parseInt(br.readLine());

        // inpurt integer 2.
        // ex) 1 2
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // input String 1.
        // ex) hello
        String s = br.readLine();

        // input String 2.
        // ex) hello world
        st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();
    }
}