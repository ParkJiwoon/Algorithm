import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1620

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String pocketmon = br.readLine();
            String number = Integer.toString(i+1);
            map.put(pocketmon, number);
            map.put(number, pocketmon);
        }

        StringBuilder sb = new StringBuilder(m);
        for(int i=0; i<m; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.print(sb);
    }
}