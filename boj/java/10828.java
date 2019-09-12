// https://www.acmicpc.net/problem/10828

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            int output = -1;
            switch (input[0]) {
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    output = -1;
                    if (!stack.isEmpty()) {
                        output = stack.pop();
                    }
                    bw.write(output + "\n");
                    break;
                case "size":
                    output = stack.size();
                    bw.write(output + "\n");
                    break;
                case "empty":
                    output = 1;
                    if (!stack.isEmpty()) {
                        output = 0;
                    }
                    bw.write(output + "\n");
                    break;
                case "top":
                    output = -1;
                    if (!stack.isEmpty()) {
                        output = stack.peek();
                    }
                    bw.write(output + "\n");
                    break;
            }
        }
        bw.flush();
    }
}
