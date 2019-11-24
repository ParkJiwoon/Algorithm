/*
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * 
 * 완주하지 못한 선수
 * 
 * <풀이>
 * HashMap 에 완주한 선수들의 { 이름: 인원 } 를 저장 후
 * 참가자들 for 문 돌며 있으면 인원을 하나씩 빼줌
 * 만약 음수가 된다면 완주하지 못한 선수
 */

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String person : completion) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) - 1);
            
            if (map.get(person) < 0)
                return person;
        }
        
        return "";
    }
}
