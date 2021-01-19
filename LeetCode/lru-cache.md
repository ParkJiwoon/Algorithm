# Problem

- [문제 링크](https://leetcode.com/problems/lru-cache/)

<br>

LRU Cache 를 구현하는 문제입니다.

Least Recently Used (LRU) 란 새로운 데이터를 삽입할 때 사용 빈도수가 낮은 데이터부터 삭제하는 캐싱 기법입니다.

<br><br>

# Solution

원래 정석대로 구현하자면 Key - Value 를 갖는 Node 클래스를 만들어서 연결 리스트로 구현하면 되지만 Java 에는 `LinkedHashMap` 이라는 자료구조가 있습니다.

내부적으로 `Map` 과 `LinkedList` 를 사용해서 데이터를 넣은 순서를 지켜줍니다.

<br>

그리고 이 `LinkedHashMap` 은 생성자에서 `accessOrder` 라는 값을 받습니다.

이 값을 `true` 로 넘겨주면 접근 빈도에 따라서 순서가 바뀌게 됩니다.

<br>

예를 들어 아래 코드에서 `a`, `b` 순서로 키값을 넣어서 `{ a=1, b=2 }` 순서로 들어있지만, `a` 에 접근했더니 순서가 바뀝니다.

이처럼 가장 최근에 접근한 값이 연결 리스트의 마지막으로 이동하게 됩니다.

따라서 가장 사용되지 않은 값은 맨 첫번째에 남게 됩니다.

```java
Map<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
map.put("a", "1");
map.put("b", "2"); // {a=1, b=2}
map.get("a");      // {b=2, a=1}
map.forEach((k, v) -> System.out.print(k + ": " + v + ", ")); // b: 2, a: 1
```

<br>

두번째 코드는 LeetCode 에서만 될 것 같은 방법 `LinkedHashMap` 자체를 상속받아서 구현했습니다.

`removeEldestEntry` 는 가장 오래된 `Entry` 를 삭제하기 때문에 좀더 편하게 구현할 수 있습니다.

<br><br>

# Java Code

### 1. LinkedHashMap 을 클래스 내부에 선언해서 구현

```java
class LRUCache {
    private final Map<Integer, Integer> map;
    private final int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);

        if (map.size() > capacity) {
            int leastUsedKey = map.keySet().iterator().next();
            map.remove(leastUsedKey);
        }
    }
}
```

<br>

### 2. LinkedHashMap 을 상속받아서 구현

```java
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
```
