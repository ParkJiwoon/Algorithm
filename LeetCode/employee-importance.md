# Problem

- [문제 링크](https://leetcode.com/problems/employee-importance/)

<br>

ID, 중요도, 부하직원 리스트를 속성으로 가진 `Employee` 클래스가 있습니다.

모든 직원들 리스트와 특정 직원의 ID 를 지목했을 때 그 직원을 포함하여 하위 모든 직원들의 중요도 합을 구하는 문제입니다.

<br><br>

# Solution

각 직원들이 노드인 트리라고 생각하면 됩니다.

직원들의 ID 를 키로 한 `HashMap` 을 하나 선언한 뒤, 선택된 `id` 부터 DFS 또는 BFS 로 순회하며 모든 합을 구하면 됩니다.

<br><br>

# Java Code

```java
// BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach(e -> map.put(e.id, e));
        
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while (!q.isEmpty()) {
            Employee employee = map.get(q.poll());
            res += employee.importance;
            q.addAll(employee.subordinates);
        }
        
        return res;
    }
}

// DFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach(e -> map.put(e.id, e));
        return dfs(map, id);
    }
    
    public int dfs(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        return e.importance + e.subordinates.stream().mapToInt(subId -> dfs(map, subId)).sum();
    }
}
```
