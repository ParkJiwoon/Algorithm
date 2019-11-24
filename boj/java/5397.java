// https://www.acmicpc.net/problem/5397

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            Deque<Character> preFix = new ArrayDeque<>();
            Deque<Character> postFix = new ArrayDeque<>();

            for (int j=0, len=s.length(); j<len; j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '<':
                        if (!preFix.isEmpty()) postFix.addFirst(preFix.pollLast());
                        break;
                    case '>':
                        if (!postFix.isEmpty()) preFix.addLast(postFix.pollFirst());
                        break;
                    case '-':
                        if (!preFix.isEmpty()) preFix.pollLast();
                        break;
                    default:
                        preFix.add(c);
                }
            }

            while (!preFix.isEmpty()) sb.append(preFix.pollFirst());
            while (!postFix.isEmpty()) sb.append(postFix.pollFirst());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}