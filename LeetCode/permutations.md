# Problem

- [문제 링크](https://leetcode.com/problems/permutations/)

<br>

배열이 주어졌을 때 해당 배열의 모든 순열을 구해서 리턴하는 문제입니다.

<br><br>

# Solution

Backtarcking 을 사용해서 풀면 됩니다.

보통 백트래킹을 사용할 때는 방문 체크를 하기위한 `boolean` 변수를 사용하는데 어차피 `List` 에 담을 거라면 굳이 그럴 필요 없이 `contains` 로 체크합니다.

문제에 제시된 조건 중에 `nums` 의 길이가 최대 6 이라서 상관없겠지만 만약 길이가 길다면 `contains` 보다는 `boolean` 배열을 사용하는 게 더 효율적입니다.

<br>

첫 번째 방법은 임시 리스트인 `list` 에다가 값을 담으면서 계속 재귀를 반복합니다.

`list` 의 사이즈가 `nums` 의 길이와 같아지면 최종 리턴값인 `result` 에 넣고 다시 재귀를 벗어날 때 다시 `list` 의 마지막 원소를 제거합니다.

<br>

두 번째 방법은 똑같이 백트래킹을 사용하지만 임시 리스트에 담지 않고 `nums` 배열의 원소를 swaop 하면서 푸는 방법입니다.

`swap` 함수를 이용하여 `nums` 의 원소 위치를 직접 바꾸고 마지막에 리스트에 담아서 `result` 에 넣습니다.

<br><br>

# Java Code

```java
// 1. without Swap
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>());
        return result;
    }
    
    public void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int num : nums) {
            if (list.contains(num)) continue;
            
            list.add(num);
            backtracking(nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}

// 2. with Swap
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, 0);
        return result;
    }
    
    public void backtracking(int[] nums, List<List<Integer>> result, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) { list.add(num); }
            result.add(list);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtracking(nums, result, start + 1);
            swap(nums, start, i);
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun permute(
        nums: IntArray,
        temp: List<Int> = listOf(),
        numsList: List<Int> = nums.toList()
    ): List<List<Int>> = when (numsList.size) {
        1 -> listOf(temp + numsList)
        else -> numsList.flatMap { num -> permute(nums, temp + num, numsList - num) }
    }
}
```
