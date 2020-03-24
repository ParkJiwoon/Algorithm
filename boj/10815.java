import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10815

class Main {
    static int stoi(String s) { return Integer.parseInt(s);}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        BitSet bitSet = new BitSet();
        int n = stoi(br.readLine());
        
        // set array index
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
        bitSet.set(stoi(st.nextToken()) + 10000000);

        int m = stoi(br.readLine());
        
        // print
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            if(bitSet.get(stoi(st.nextToken())  + 10000000))
                sb.append("1 ");
            else
                sb.append("0 ");
        }

        System.out.println(sb);
    }
}
