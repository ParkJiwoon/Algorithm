import java.util.*;
import java.io.*;

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String maxBook = "";
        int max = 0;
        int n = stoi(br.readLine());

        // 처음 나오는거라면 1, 아니면 숫자를 하나씩 증가시킴
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (!map.containsKey(book))
                map.put(book, 1);
            else
                map.put(book, map.get(book) + 1);
        }

        // HashMap을 돌며 value가 최대값인 책을 찾음
        // 만약 value가 같다면 책이 사전순으로 앞서는 것을 출력
        for (String key : map.keySet()) {
            int value = map.get(key);

            if (max == value && maxBook.compareTo(key) > 0) {
                maxBook = key;
                max = value;
            } else if (max < value) {
                maxBook = key;
                max = value;
            }
        }

        System.out.println(maxBook);
    }
}