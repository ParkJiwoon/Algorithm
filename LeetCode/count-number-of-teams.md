
# Problem

- [문제 링크](https://leetcode.com/problems/count-number-of-teams)

<br>

n 개의 rating 순서가 주어질 때, 만들어질 수 있는 팀의 갯수를 구하는 문제입니다.

팀을 만드려면 3 개의 rating 이 오름차순 또는 내림차순으로 존재해야 합니다.

<br><br>

# Solution

팀의 인원은 반드시 3 명이라는 점에 주목할 수 있습니다.

3 명이라면 어떤 값을 가운데 기준으로 잡았을 때, 왼쪽에 있는 값은 더 작고 오른족에 있는 값은 더 커야 오름차순이 됩니다.

또는 반대가 되면 내림차순이 됩니다.

아래와 같은 순서로 코드를 작성하면 해결할 수 있습니다.

1. `ratings` 를 전체 순회하면서 가운데 기준값을 잡는다.
2. 기준값 기준으로 왼쪽에서 더 작은 값 갯수, 오른쪽에서 더 큰 값 갯수를 구해 곱한다 (오름차순인 팀 경우의 수)
3. 기준값 기준으로 왼쪽에서 더 큰 값 갯수, 오른쪽에서 더 작은 값 갯수를 구해 곱한다 (내림차순인 팀 경우의 수)
4. 두 값을 더하면 만들어질 수 있는 모든 팀의 수가 나온다.

<br>

<img width="854" alt="image" src="https://user-images.githubusercontent.com/28972341/225161444-a48432ce-028b-4679-9c8a-25d1d0f76dff.png">

예를 들어 그림으로 표현하면 위와 같습니다.

6 을 기준으로 오름차순은 168, 368, 568 이 존재하고 내림차순은 962, 964, 762, 764 이 존재합니다.

오름차순으로 봤을 때 왼쪽에는 1, 3, 5 세개가 있고 오른쪽에는 8 하나가 존재하기 때문에 오름차순 팀이 만들어질 수 있는 경우의 수는 1 * 3 입니다.

내림차순을 보면 왼쪽에 9, 7 이 존재하고 오른쪽에 4, 2 가 존재하기 때문에 내림차순 팀이 만들어질 수 있는 경우의 수는 2 * 2 입니다.

그러므로 가운데 숫자가 6 일때 만들 수 있는 팀은 7 개가 됩니다.

이런식으로 앞에서부터 모든 숫자에 하나씩 가운데 숫자를 대입하면서 끝까지 돌면 만들 수 있는 모든 팀의 갯수를 구할 수 있습니다.

<br><br>

# Java Code

```java
class Solution {
    public int numTeams(int[] rating) {
        int teamCount = 0;

        for (int mid = 0; mid < rating.length; mid++) {
            int leftSmaller = 0;
            int leftLager = 0;
            int rightSmaller = 0;
            int rightLager = 0;

            for (int left = 0; left < mid; left++) {
                if (rating[left] < rating[mid]) {
                    leftSmaller++;
                } else {
                    leftLager++;
                }
            }

            for (int right = mid + 1; right < rating.length; right++) {
                if (rating[right] < rating[mid]) {
                    rightSmaller++;
                } else {
                    rightLager++;
                }
            }

            teamCount += (leftSmaller * rightLager) + (leftLager * rightSmaller);
        }

        return teamCount;
    }
}
```

