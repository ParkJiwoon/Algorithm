# Problem
- 문제 링크 : https://leetcode.com/problems/insert-delete-getrandom-o1/

문제에서 요구하는 사항에 맞게 RandomizedSet 을 구현하는 문제입니다.
`insert(val)`, `remove(val)`, `getRandom()` 함수를 구현해야 하는데 모두 `O(1)` 의 시간복잡도를 가져야 합니다.
<br>
<br>

# Solution
`ArrayList<Integer>`와 `HashMap<Integer, Integer>`을 이용하여 만들 수 있습니다.

처음에는 `HashSet<Integer>`을 사용하려고 했는데 `getRandom()` 함수에서 값을 꺼낼 때 반복문을 돌아야 한다는 단점이 있었습니다.

그래서 index-value 를 key-value 로 하고 value-index 를 key-value 로 하는 HashMap 두개를 이용해서 풀었습니다.

그런데 index-value 가 key-value 인 HashMap 은 결국 List 와 다를게 없어서 List 로 수정하여 최종 구현하였습니다.

`insert(val)` 와 `getRandom()` 은 별다른 설명이 필요 없을 것 같고 결국 `remove(val)` 을 어떻게 `O(1)` 시간에 하느냐가 관건입니다.

가장 고민했던 부분은 중간에 있는 val 을 삭제할 경우 List 의 index 에 구멍이 생겨서 랜덤값이 제대로 뽑히지 않는다는 점이었습니다.

그래서 중간에 있는 값을 삭제하는 대신에 List 의 가장 마지막 값으로 삭제하는 위치를 채우는 방법을 사용했습니다.

다음 그림과 같이 List 값이 들어있다고 가정합니다.

![example1](./image/insert-delete-getrandom-o1_1.jpg)

여기서 `remove(9)` 를 호출하면 두번째 index 값이 지워져야 합니다.

하지만 index 값을 지우는 대신에 마지막에 있는 14 값으로 채워넣고 마지막 index 를 삭제해버리면

list 내의 index 는 순차적으로 모두 존재함이 보장됩니다.

![example2](./image/insert-delete-getrandom-o1_2.jpg)
<br>
<br>

# Java Code
```java
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);
        int deletedIndex = map.get(val);

        list.set(deletedIndex, lastValue);
        map.put(lastValue, deletedIndex);
        
        list.remove(lastIndex);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int rand = (int) (Math.random() * list.size());
        return list.get(rand);
    }
}
```