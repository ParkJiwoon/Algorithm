/**
 * 문제: https://leetcode.com/problems/merge-two-sorted-lists/
 * 풀이: https://bcp0109.tistory.com/126
 */

// Using PriorityQueue
import java.util.*

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val pq = PriorityQueue<Int>()
            var _l1 = l1
            var _l2 = l2

            while (_l1 != null) {
                pq.add(_l1.`val`)
                _l1 = _l1.next
            }

            while (_l2 != null) {
                pq.add(_l2.`val`)
                _l2 = _l2.next
            }

            var node: ListNode? = ListNode(0)
            val result: ListNode? = node

            while (pq.isNotEmpty()) {
                node?.next = ListNode(pq.poll())
                node = node?.next
            }

            return result?.next
    }
}



// Using Just Loop
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var _l1 = l1
        var _l2 = l2
        var node: ListNode? = ListNode(0)
        var result: ListNode? = node
        
        while (_l1 != null && _l2 != null) {
            if (_l1.`val` < _l2.`val`) {
                node?.next = ListNode(_l1.`val`)
                _l1 = _l1.next
            } else {
                node?.next = ListNode(_l2.`val`)
                _l2 = _l2.next
            }
            
            node = node?.next
        }
        
        if (_l1 != null) {
            node?.next = _l1
        } else {
            node?.next = _l2
        }
        
        return result?.next
    }
}


// Using Recursive
import java.util.*

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        
        if(l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            return l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            return l2
        }
    }
}
