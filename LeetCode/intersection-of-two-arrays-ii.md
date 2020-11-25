# Problem

- [문제 링크](https://leetcode.com/problems/intersection-of-two-arrays-ii/)

<br>

두 배열에서 중복되는 원소들을 모아서 만든 배열을 구하는 문제입니다.

<br><br>

# Solution

각 배열에 같은 숫자가 여러 개 존재하면 겹치는 만큼 전부 리턴해야 하기 때문에 일반적인 교집합과는 조금 다릅니다.

결국 각 숫자에 있는 값들을 전부 비교하는 수밖에 없습니다.

원소의 범위가 정해져 있지 않으므로 `HashMap` 을 사용해서 개수를 비교하면 됩니다.

<br>

Folllow up 1 에서 두 배열이 정렬된 상태면 어떻게 최적화 가능하냐는 질문이 있습니다.

각 배열이 정렬된 상태라면 `Two pointer` 를 사용하여 풀 수 있습니다.

<br>

Follow up 2 에서 정렬된 상태이면서 한쪽 배열의 크기가 무조건 작을 경우 어떻게 최적화 하는 지 다시 물어봅니다.

`nums1` 배열의 크기가 작다면 `nums1` 배열을 전체 순회하면서 각 원소 값을 `nums2` 에서 이진 탐색을 이용하여 찾으면 됩니다.

중복된 값 처리 때문에 귀찮아서 구현은 생략합니다.

<br><br>

# Java Code

```java
// Normal Solution - Using HashMap O(n + m)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // <number, count>
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums1) {
            map.merge(num, 1, Integer::sum);
        }
        
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            
            if (count > 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }
        
        return list.stream().mapToInt(k -> k).toArray();
    }
}


// Follow up 1 - O(max(n, m))
// What if the given array is already sorted? 
// How would you optimize your algorithm?
// 두 배열이 정렬된 상태면 two-pointer 를 사용해서 최적화 가능
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return list.stream().mapToInt(k -> k).toArray();
    }
}
```
