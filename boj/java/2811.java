import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2811

class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Day {
        int length, start;

        public Day(int l, int s) {
            this.length = l;
            this.start = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = stoi(br.readLine());

        List<Day> day = new ArrayList<Day>();
        boolean[] flower = new boolean[N+1];
        int maxLength = 0;
        boolean sad = false;    // 우울한 날이 지속되는지 판단
        int start=0;
        int length=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int input = stoi(st.nextToken());

            // 우울한 날일때
            if(input < 0) {
                // 이미 우울한 날이 지속중이면 길이만 늘리고 아니면 해당 날부터 새로 시작
                if(sad)
                    length++;
                else {
                    sad = true;
                    start = i;
                    length = 1;
                }
            } else {
                // 우울하지 않은 날을 만났을 때 우울한 상태였다면 List에 추가
                if(sad) {
                    day.add(new Day(length, start));
                    maxLength = Math.max(maxLength, length);
                    sad = false;
                }
            }
        }
        
        // 우울한 날이 끝까지 지속되면서 끝난 경우 마지막에 추가해줌
        if(sad)
            day.add(new Day(length, start));

        // 모든 우울 기간에 대해서 *2 만큼 체크
        int count = 0;  // 꽃을 주는 날의 갯수
        for(Day d : day) {
            int startDay = Math.max(0, d.start - d.length * 2);
            int endDay = d.start;

            for(int i=startDay; i<endDay; i++) {
                if(flower[i])
                    continue;
                flower[i] = true;
                count++;
            }
        }

        // 최장 우울 기간에 대해서 *3 만큼 count
        // 여러개 일 수 있으므로 체크는 하지 말고 갯수만 카운트한 뒤에 max를 구한다.
        int result = 0;
        for(Day d : day) {
            // 최장 우울 기간이 아니면 pass
            if(d.length != maxLength)
                continue;

            int add = 0;
            int startDay = Math.max(0, d.start - d.length * 3);
            int endDay = d.start;

            for(int i=startDay; i<endDay; i++) {
                if(flower[i])
                    continue;
                add++;
            }

            if(result < count + add)
                result = count + add;
        }

        System.out.println(result);
    }
}