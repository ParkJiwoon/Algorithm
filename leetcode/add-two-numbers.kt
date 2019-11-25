// 문제: https://leetcode.com/problems/add-two-numbers
// 풀이: https://bcp0109.tistory.com/131

// 캐리 변수 사용
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var _l1 = l1
        var _l2 = l2
        var node = ListNode(0)
        var result = node
        var carry = 0
        
        while (_l1 != null || _l2 != null) {
            var sum = carry
            sum += _l1?.`val` ?: 0
            sum += _l2?.`val` ?: 0
                        
            if (sum >= 10) {
                node?.next = ListNode(sum - 10)
                carry = 1
            } else {
                node?.next = ListNode(sum)
                carry = 0
            }
            
            node = node?.next
            _l1 = _l1?.next
            _l2 = _l2?.next
        }
        
        if (carry == 1) {
            node?.next = ListNode(1)
        }
        
        return result?.next
    }
}

// 나머지 연산을 사용하여 Sum 변수만 이용
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var _l1 = l1
        var _l2 = l2
        var node = ListNode(0)
        var result = node
        var sum = 0
        
        while (_l1 != null || _l2 != null || sum > 0) {
            sum += _l1?.`val` ?: 0
            sum += _l2?.`val` ?: 0
            
            node?.next = ListNode(sum % 10)
            sum /= 10
            
            node = node?.next
            _l1 = _l1?.next
            _l2 = _l2?.next
        }
        
        return result?.next
    }
}
