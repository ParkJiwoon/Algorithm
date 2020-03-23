# Problem

- [문제 링크](https://leetcode.com/problems/3sum/)

<br>

*__Medium__* 난이도의 문제입니다.

nums 배열에서 합이 0이 되는 세개의 원소 리스트들을 return 하면 됩니다.

<br><br>

# Solution

백준에서 풀어보았던 세 용액과 비슷한 문제이지만 해당되는 리스트를 전부 `return` 해야된다는 점과

배열에는 중복된 원소가 존재하지만 실제 `return` 하는 값에는 중복된 리스트를 전부 빼야 한다는 점이 다르다고 할 수 있습니다.

세 용액을 풀었던 것과 마찬가지로 모든 원소들에 대하여 두 용액 풀이로 리스트를 구했습니다.

<br>

> 두 용액 풀이 (`a + b = c` 가 되는 `a`, `b` 구하기)
> 1. 배열을 오름차순으로 정렬합니다.
> 2. 배열의 양 끝에 있는 숫자의 합과 `c` 를 비교합니다.
> 3. 합이 `c` 보다 작다면 왼쪽 `index` 를 1 증가 시킵니다. (`c` 보다 작기 때문에 작은 값을 증가시킴)
> 4. 합이 `c` 보다 크다면 오른쪽 `index` 를 1 감소 시킵니다. (`c` 보다 크기 때문에 큰 값을 감소시킴)
> 5. 순차적으로 두 숫자의 사이를 좁히면서 만나기 전까지 합이 `c` 가 되는 모든 경우를 구합니다.

<br>

위 풀이를 응용하면 `a + b + c = d` 또한 구할 수 있습니다.

`c` 값을 미리 정해두고 `a, b` 값을 구하면 됩니다.

배열 원소 중 하나를 미리 `c` 값으로 정해두고 `a`, `b` 값을 구하는 방식으로 모든 `a, b, c` 경우의 수를 구할 수 있습니다.

두 용액은 `O(n)` 이지만 세 용액은 모든 `n` 에 대하여 두 용액을 한번씩 적용해야되므로 `O(n^2)` 의 시간 복잡도를 가집니다.

그리고 이 문제는 시간을 줄일 수 있는 요소가 존재합니다.

먼저 숫자에 해당하는 값이 나오면 `left` 또는 `right` 중 하나만 바꿀 필요 없이 둘다 바꿔도 됩니다.

`a + b = 0` 인데 `a` 나 `b` 만 바꾸면 0 이 무조건 되지 않기 때문입니다.

두번째로 `nums` 배열에는 중복값이 존재합니다.

`left++` 혹은 `right--` 할때 이전값과 비교해서 중복되는 값이 나오지 않을 때까지 계속 패스할 수 있습니다.

`[1, 1, 1, 1, 1]` 이런 배열이 들어왔을 때 기존 코드는 일일히 비교해야하지만 중복되는 값을 패스하게 하면 처음만 비교하고 나머지는 전부 넘길 수 있습니다.

<br><br>

# Java Code

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (nums[left] == nums[left - 1] && left < right) left++;
                    while (nums[right] == nums[right + 1] && left < right) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return res;
    }
}
```