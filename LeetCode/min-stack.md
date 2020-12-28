# Problem

- [문제 링크](https://leetcode.com/problems/min-stack/)

<br>

문제에서 주어진 조건대로 Min Stack 을 구현하는 문제입니다.

일반 Stack 과 똑같지만 `getMin()` 이라는 메소드로 스택의 최소값을 뽑을 수 있습니다.

<br><br>

# Solution

바로 떠올릴 수 있는 방법은 `Stack` 을 두 개 사용해서 구현하는 겁니다.

한 개는 최소값만 보관하고 한 개는 일반적인 스택으로 사용합니다.

<br>

공간복잡도를 줄이기 위해 변수 하나만 사용해서 구현하는 방법이 있습니다.

최소값을 보관하는 `min` 변수를 선언합니다.

이 값에는 `getMin()` 호출 시에 리턴할 최소값을 유지하고 있습니다.

<br>

이제 최소값이 pop 되었을 때, 다음 최소값을 어떻게 알 수 있는지가 문제입니다.

방법은 push 로 인해 최소값이 갱신될 때 `min` 을 바꾸기 전에 Stack 에 하나 넣어두는 겁니다.

그리고 pop 한 값이 최소값과 동일하면 한번 더 pop 을 해서 `min` 에 넣어줍니다.

최소값이 pop 된 순간에 바로 밑에는 다음 최소값이 기록되어 있는 셈입니다.

Worst Case 일때는 스택 두개를 쓰는 것과 메모리 사용이 동일하지만 Best Case 일 때는 1/2 밖에 사용하지 않습니다.

<br><br>

# Java Code

```java
class MinStack {
    int min;
    Stack<Integer> stack;
    
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
```
