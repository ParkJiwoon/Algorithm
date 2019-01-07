import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10809

class Main {
    static int stoi(String s) { return Integer.parseInt(s);}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        
        for(int i='a'; i<='z'; i++)
            bw.write(s.indexOf(i) + " ");
            
        bw.write("\n");
        bw.flush();
    }
}