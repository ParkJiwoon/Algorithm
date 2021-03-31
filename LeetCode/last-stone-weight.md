# Problem

- [문제 링크](https://leetcode.com/problems/last-stone-weight/)

<br>

각 돌들의 무게가 배열로 주어집니다.

**가장 무거운 돌** 하나와 **두 번째로 무거운 돌** 하나를 선택해서 둘을 부딪힙니다.

둘의 무게가 같다면 둘다 사라지고 한쪽이 더 크다면 작은 쪽은 사라지고 큰 놈은 **두 돌의 무게의 차이** 만큼 남습니다.

돌이 하나만 남을 때까지 반복했을 때 마지막으로 남은 돌의 무게는 얼마인지 구하는 문제입니다.

<br><br>

# Solution 1 - 우선순위 큐

우선순위 큐를 사용합니다.

일반적으로 `PriorityQueue<Integer>` 는 작은 숫자가 먼저 나오기 때문에 `Collections.reverseOrder()` 를 사용하여 큰 수가 먼저 나오도록 선언합니다.

우선순위 큐가 비거나 `size` 가 1 이 될 때까지 두번씩 `poll` 하며 돌의 무게를 비교합니다.

둘이 같은 경우는 사라져야 하기 때문에 `pq` 에 추가하지 않습니다.

만약 돌의 무게가 다르다면 먼저 뽑은 `y` 가 더 큰 돌이므로 `y - x` 값을 `pq` 에 넣습니다.

`pq` 에 하나만 남는다면 무게를 리턴하고 아니면 0 을 리턴합니다.

<br>

# Java Code 1

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int stone : stones) {
            pq.add(stone);
        }
        
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            
            if (y != x) {
                pq.add(y - x);
            }
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
```

<br><br>

# Solution 2 - 정렬

방법 자체는 단순하게 두 돌을 구한 뒤 한쪽은 없애고 차이만 남기면 됩니다.

그렇다면 문제는 돌 두개를 어떻게 고르느냐 하는 건데 전 그냥 정렬을 사용했습니다.

정렬하면 가장 끝에 있는 두 돌이 가장 무거운 돌들입니다.

정렬 후 : `[..., x, y]`

`x` 와 `y` 를 부딪히면 `x` 는 같거나 작기 때문에 무조건 없어지고 `y = y - x` 가 됩니다.

`y - x` 값을 배열에 다시 넣고 `Arrays.copyOf` 으로 마지막 인덱스를 없애줍니다.

이런식으로 쭉 반복하면 마지막에는 돌 하나만 남게됩니다.

<br>

# Java Code 2

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        for (int i = stones.length - 1; i > 0; i--) {
            Arrays.sort(stones);
            stones[i - 1] = stones[i] - stones[i - 1];
            stones = Arrays.copyOf(stones, i);
        }
        
        return stones[0];
    }
}
```
