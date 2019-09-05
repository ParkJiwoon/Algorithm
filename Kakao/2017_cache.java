// https://programmers.co.kr/learn/courses/30/lessons/17680

import java.util.*;

class Solution {
  public int solution(int cacheSize, String[] cities) {
      int answer = 0;
      
      if(cacheSize == 0) 
          return cities.length * 5;
      
      LinkedList<String> cache = new LinkedList<String>();
      
      for(int i=0; i<cities.length; i++) {
          String city = cities[i].toLowerCase();
          
          if(cache.contains(city)) {
              // 캐시 안에 이미 값이 있으면
              cache.remove(city);
              cache.add(city);
              answer += 1;
          } else {
              // 캐시 안에 값이 없으면
              if(cache.size() >= cacheSize) 
                  cache.remove(0);       

              cache.add(city);
              answer += 5;
          }             
      }
      
      return answer;
  }
}