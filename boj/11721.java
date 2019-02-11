import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11721
// java version "1.8.0_131"

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = str.length();

        while (true) {
            if (N <= 10) {
                System.out.println(str);
                break;
            } else {
                System.out.println(str.substring(0, 10));
                str = str.substring(10, N);
                N -= 10;
            }
        }
    }
}