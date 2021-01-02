# Problem

- [문제 링크](https://leetcode.com/problems/find-the-duplicate-number/)

<br>

`nums` 배열의 중복된 숫자를 찾는 문제입니다.

중복된 숫자는 여러번 나올수 있으며 나머지 숫자들은 전부 한번만 등장합니다.

`nums` 배열의 길이가 `n` 이라고 할 때 등장하는 숫자들의 범위는 `1 ~ n` 입니다.

<br><br>

# Solution

토끼와 거북이 알고리즘으로 풀 수 있습니다.

`nums` 에 있는 값들을 인덱스로 취급해서 계속 이동합니다.

중복된 값이 최소 한개는 존재하기 때문에 반드시 싸이클이 생깁니다.

```java
Input: [1,3,4,2,2]
1 -> 3 -> 2 (싸이클 시작점) -> 4 -> 2 (두번째 2) -> 4 -> 2 -> 4 -> ..

Input: [3,1,3,4,2]
3 (싸이클 시작점) -> 4 -> 2 -> 3 (두번째 3) -> 4 -> 2 -> ...

Input: [1,1]
1 (싸이클 시작점) -> 1 (두번째 1) -> 1 -> ...

Input: [1,1,2]
1 -> 1 -> 1 -> ...

Input: [4,1,2,3,4]
4 -> 4 -> 4 -> ...
```

<br>

토끼와 거북이 알고리즘을 사용하면 싸이클을 찾을 수 있을 뿐만 아니라 싸이클의 시작 지점을 찾을 수 있습니다.

싸이클은 중복된 숫자 인덱스부터 시작되기 때문에 싸이클의 시작 지점 값이 중복 값이 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int findDuplicate(int[] nums) {
        // find cycle
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // find cycle start point        
        int index = 0;
        while (slow != index) {
            index = nums[index];
            slow = nums[slow];
        }
        
        return index;
    }
}
```
