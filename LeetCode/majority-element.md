# Problem

- [문제 링크](https://leetcode.com/problems/majority-element/)

<br>

배열이 주어졌을 때 가장 많이 나오는 숫자를 찾아 리턴하는 문제입니다.

가장 많이 나오는 빈도는 문제에 명시된 대로 `배열의 길이 / 2` 입니다.

<br><br>

# Solution

여러가지 풀이가 존재할 수 있습니다.

시간 복잡도만 고려해서 `HashMap` 을 사용해서 숫자들의 카운트를 기록했는데 Discuss 를 보니 `Moore Voting Algorithm` 라는 더 좋은 해답이 있었습니다.

Sort 는 그냥 길이가 짧고 신기해서 넣었습니다.

<br><br>

# Java Code

```java
// 1. Using HashMap - Time: O(n), Space: O(n)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            
            if (count > nums.length / 2) {
                return num;
            }
        }
        
        return 0;
    }
}

// 2. Using Sort - Time: O(n logn), Space: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

// 3. Using Moore Voting Algorithm (From Discuss)
// Time: O(n), Space: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int curr = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                curr = num;
            } 
            
            count += (curr == num) ? 1 : -1;
        }
        
        return curr;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun majorityElement(nums: IntArray): Int {
        return nums.groupBy { it }
                   .filterValues { it.size > (nums.size / 2) }
                   .keys
                   .first()
    }
}
```
