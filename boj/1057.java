import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1057

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int kim = stoi(st.nextToken());
        int lim = stoi(st.nextToken());

        int round = 0;

        // 부모 노드가 같은 번호일 때 만남
        while (kim != lim) {
            kim = kim / 2 + kim % 2;    // kim = (kim+1)/2;
            lim = lim / 2 + lim % 2;    // lim = (lim+1)/2;
            round++;
        }

        System.out.println(round);
    }
}
