# Problem

- [문제 링크](https://leetcode.com/problems/find-duplicate-file-in-system/)

<br>

난이도 **_Medium_** 입니다.

같은 content 를 가진 `path/file` 을 각각의 리스트로 묶는 문제입니다.

a, b 라는 이름의 content 가 있을 때 a 의 위치를 나타내는 listA 와 b 의 위치를 나타내는 listB 를 큰 리스트로 묶어서 `[listA, listB]` 를 리턴하면 됩니다.

<br><br>

# Solution

귀찮긴 하지만 간단한 문제입니다.

Input 은 다음과 같은 형식입니다.

```html
[
    "root path(content) path(content)",
    "root path(content)"
]
```

우선 `split(" ")` 을 사용하여 `root` 를 구합니다.

그 뒤에 여는 괄호를 기준으로 split 을 한번 더 해서 `path / content)` 형식으로 나눕니다.

`path` 는 온전하게 구해야 하지만 `content` 는 어차피 고유의 이름을 갖고 있으므로 뒤에 괄호가 하나 더 붙어도 상관없습니다.

`content)` 를 key 값으로 하고 나머지 `root/path` 의 리스틀들을 value 로 하는 `Map` 을 만들어줍니다.

이 중에서 `root/path` 의 갯수가 최소 두개 이상이 되는 content 들을 새로 담으면 됩니다.


<br><br>

# Java Code

```java
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        // Map<content, [paths/fileName, ...]>
        Map<String, List<String>> map = new HashMap<>(); 
        
        for (String path : paths) {
            // [root/a, 1.txt(abcd), 2.txt(efgh)]
            String[] files = path.split(" ");
            String root = files[0];
            
            for (int i = 1; i < files.length; i++) {
                // [1.txt, abcd)]
                String[] fileAndContent = files[i].split("\\(");
                String file = fileAndContent[0];
                String content = fileAndContent[1];
                
                List<String> list = map.getOrDefault(content, new ArrayList<String>());
                list.add(root + "/" + file);
                map.put(content, list);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        map.forEach((k, v) -> {
            if (v.size() > 1) {
                result.add(v);
            }
        });
        
        return result;
    }
}
```