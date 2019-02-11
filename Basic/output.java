import java.io.*;
import java.util.*;

// 연습 문제 : https://www.acmicpc.net/problem/15552

class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        long start, end;

        // System.out.print TEST
        start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++)
            System.out.print(i);

        end = System.currentTimeMillis();
        double sysTime = (end - start) / 1000.0;


        // bw.write TEST
        start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++)
            bw.write(i + "");

        bw.flush();
        end = System.currentTimeMillis();
        double bwTime = (end - start) / 1000.0;


        // sb.append TEST
        start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++)
            sb.append(i);

        System.out.print(sb);
        end = System.currentTimeMillis();
        double sbTime = (end - start) / 1000.0;

        // Result
        System.out.println();
        System.out.println("sysTime : " + sysTime);
        System.out.println("bwTime : " + bwTime);
        System.out.println("sbTime : " + sbTime);
    }
}