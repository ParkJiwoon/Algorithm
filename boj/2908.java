import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2908

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        String a1 = new StringBuffer(a).reverse().toString();
        String b1 = new StringBuffer(b).reverse().toString();

        if(stoi(a1) > stoi(b1))
            System.out.println(a1);
        else
            System.out.println(b1);
    }
}