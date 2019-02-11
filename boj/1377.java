import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1377

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Pair implements Comparable<Pair> {
        int index;
        long value;

        public Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Pair o) {
            if (this.value > o.value)
                return 1;
            else if (this.value < o.value)
                return -1;

            // stable 을 보장하기 위해 인덱스 비교도 추가
            if (this.index > o.index)
                return 1;
            else
                return -1;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());
        int max = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(i, stoi(br.readLine())));
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            if (max < pair.index - idx)
                max = pair.index - idx;

            idx++;
        }

        System.out.println(max + 1);
    }
}