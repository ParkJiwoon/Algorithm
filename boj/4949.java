import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4949

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] stack = new char[1001];

        while(true) {
            String input = br.readLine();

            if(input.equals(".")) {
                bw.flush();
                bw.close();
                return;
            }

            int cursor = 0;
            boolean result = true;

            // 한 글자씩 검사
            for(char one : input.toCharArray()) {
                switch(one) {
                    case '(':
                    case '[':
                        stack[cursor++] = one;
                        break;
                    case ')':
                        if(cursor == 0 || stack[--cursor] != '(')
                            result = false;
                        break;
                    case ']':
                        if(cursor == 0 || stack[--cursor] != '[')
                            result = false;
                        break;
                }

                if(!result)
                    break;
            }

            // 모든 검사가 끝났는데 스택이 비어있지 않다면 균형잡히지 않은 것
            if(cursor > 0)
                result = false;

            if(!result)
                bw.write("no\n");
            else
                bw.write("yes\n");
        }
    }
}