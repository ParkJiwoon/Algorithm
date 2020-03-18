# Problem
- 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/17680

LRU 캐시 교체 알고리즘(Least Recently Used)을 구현하면 됩니다.
<br>
<br>

# Solution
LRU 알고리즘이란 가장 오랫동안 사용되지 않은 데이터를 교체하는 겁니다.

크기가 3 인 캐시에 [1, 2, 3, 1] 순서로 데이터가 들어갔다면 1 이 가장 오래된 데이터지만 가장 오랫동안 사용되지 않은 데이터는 2 입니다.

따라서 새로운 데이터 4 가 들어간다면 2 를 삭제하고 [3, 1, 4] 가 남게 됩니다.

삽입 삭제가 많이 일어나기 때문에 `LinkedList` 를 캐시로 사용하였습니다.

캐시 안에 이미 도시 이름이 존재하면 기존에 있는 걸 삭제 후 마지막에 도시를 다시 넣어서 갱신해줍니다.

캐시 안에 도시 이름이 존재하지 않으면 새로 추가합니다.

만약 캐시가 가득차서 더 넣을수 없다면 가장 오랫동안 사용하지 않은 `index 0` 에 위치한 도시를 삭제합니다.
<br>
<br>

# Java Code
```java
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        LinkedList<String> cache = new LinkedList<>();
        
        for (String _city : cities) {
            String city = _city.toLowerCase();
            
            if (cache.contains(city)) {
                cache.remove(city);
                answer += 1;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.remove(0);       
                }
                answer += 5;
            }    
            
            cache.add(city);
        }
        
        return answer;
    }
}
```