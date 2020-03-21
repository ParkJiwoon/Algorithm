# 부분집합

- [연습 문제](https://bcp0109.tistory.com/18)

<br>

배열의 모든 부분집합을 구합니다.

배열 `[1, 2, 3]` 이 있다면 부분집합은

```html
[1]
[2]
[3]
[1, 2]
[1, 3]
[2, 3]
[1, 2, 3]
```

입니다.

뭔가 떠오르지 않나요?

바로 조합이 떠오릅니다.

저번에 포스팅했던 `n` 개 중에서 `r` 개를 순서 없이 뽑는 조합에서 `r` 에 대한 `for` 문을 돌리면 구할 수 있습니다.

하지만 단순히 부분집합을 확인하기 위한 용도라면 훨씬 빠르고 효율적인 코드가 있습니다.

부분집합 역시 구하는 방법이 여러가지 있습니다.

<br>

## 조합을 이용한 구현

[조합](https://bcp0109.tistory.com/15) 포스팅을 확인하시면 됩니다.

<br>

## 재귀를 이용한 구현

조합을 구할 때와 비슷하게 구현을 하면 됩니다.

조합에서는 길이가 `r` 일 때를 구하기 위해 여러가지 조건을 걸었지만 부분집합에서는 필요없습니다.

1. 현재 인덱스를 포함하는 경우
2. 현재 인덱스를 포함하지 않는 경우

두 가지로 경우에 대해서 모두 확인한 후에 현재 인덱스가 `n` 이 되면 출력합니다.

<br>

### Java Code

```java
static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
    if(idx == n) {
        print(arr, visited, n);
        return;
    }
 
    visited[idx] = false;
    powerSet(arr, visited, n, idx + 1);
 
    visited[idx] = true;
    powerSet(arr, visited, n, idx + 1);
}
```

<br>

### Result

```html
3
2
2 3
1
1 3
1 2
1 2 3
```

<br><br>

## 비트를 이용한 구현

비트연산에 대한 이해가 있다면 구현할 수 있습니다.

`n` 이 3이라고 할 때 `1 << n` 은 1000입니다.

첫번째 `for` 문에서 `i` 는 `1 << n` 전까지 증가하니까 111까지 증가합니다.

즉 `i` 는

```html
000
001
010
011
100
101
110
111
```

이렇게 증가합니다.

한번 쓱 보니 비트 자체만으로도 부분 집합이 형성되었습니다.

`j` 를 통해서

```html
001
010
100
```

위 숫자들과 `AND` 연산을 통해서 1 인 비트들을 인덱스처럼 사용할 수 있습니다.

<br>

### Java Code

```java
static void bit(int[] arr, int n) {
    for(int i=0; i < 1<<n; i++) {
        for(int j=0; j<n; j++) {
            if((i & 1<<j) != 0) 
                System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
```

<br>

### Result

```html
1
2
1 2
3
1 3
2 3
1 2 3
```

<br><br>

## 전체 소스코드

```java
public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = 3;
        boolean[] visited = new boolean[n];

        powerSet(arr, visited, n, 0);
        bit(arr, n);
    }

    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if (idx == n) {
            print(arr, visited, n);
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }

    static void bit(int[] arr, int n) {
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0)
                    System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
```