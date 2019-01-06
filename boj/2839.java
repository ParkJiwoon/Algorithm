import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/2839

class Main {
    static int stoi(String s) { return Integer.parseInt(s);}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = stoi(br.readLine());
        int[] kg = new int[n+1];

        // 3kg와 5kg는 무조건 1봉투
        kg[3] = 1;
        if(n > 4)
            kg[5] = 1;

        /**
         * 3kg를 빼거나 5kg를 뺐을 때 값이 존재하는 경우에만 연산
         * 둘다 값이 존재한다면 더 작은 값으로 입력
         */
        for(int i=6; i<=n; i++) {
            if(kg[i-3] > 0 && kg[i-5] > 0)
                kg[i] = Math.min(kg[i-3], kg[i-5]) + 1;
            else if(kg[i-3] > 0)
                kg[i] = kg[i-3] + 1;
            else if(kg[i-5] > 0)
                kg[i] = kg[i-5] + 1;
        }

        if(kg[n] == 0)
            System.out.println(-1);
        else
            System.out.println(kg[n]);
    }
}