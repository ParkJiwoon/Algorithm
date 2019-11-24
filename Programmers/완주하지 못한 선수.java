/*
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * 완주하지 못한 선수
 * 
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
