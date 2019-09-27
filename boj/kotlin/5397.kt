// https://www.acmicpc.net/problem/5397

import java.util.*

// Stack 두개 사용. iterator 사용과 시간 차이는 크게 나지 않는다
fun stack() {
    val n = readLine()!!.toInt()
    val sb = StringBuilder()

    repeat (n) {
        val s = readLine()!!
        val preFix = ArrayDeque<Char>()
        val postFix = ArrayDeque<Char>()

        s.forEach {
            when (it) {
                '<' -> if (preFix.isNotEmpty()) postFix.addFirst(preFix.pollLast())
                '>' -> if (postFix.isNotEmpty()) preFix.addLast(postFix.pollFirst())
                '-' -> if (preFix.isNotEmpty()) preFix.pollLast()
                else -> preFix.add(it)
            }
        }

        while (preFix.isNotEmpty()) sb.append(preFix.pollFirst())
        while (postFix.isNotEmpty()) sb.append(postFix.pollFirst())
        sb.append("\n")
    }

    print(sb)
}

// listIterator 사용. 연결리스트에서 remove가 O(n)의 시간이 걸리는 약점을 보완.
fun iterator() {
    val n = readLine()!!.toInt()
    val sb = StringBuilder()

    repeat (n) {
        val s = readLine()!!
        val output = LinkedList<Char>()
        val pos = output.listIterator()

        s.forEach {
            when (it) {
                '<' -> if (pos.hasPrevious()) pos.previous()
                '>' -> if (pos.hasNext()) pos.next()
                '-' -> if (pos.hasPrevious()) {
                    pos.previous()
                    pos.remove()
                }
                else -> pos.add(it)
            }
        }

        output.forEach { sb.append(it) }
        sb.append("\n")
    }

    print(sb)
}


// 연결리스트 사용. 중간에 있는 값을 삭제/추가 할 때 O(n)의 시간복잡도를 갖기 때문에 오래걸린다.
fun linkedList() {
    val n = readLine()!!.toInt()
    val sb = StringBuilder()

    repeat (n) {
        val output = LinkedList<Char>()
        var index = 0

        readLine()!!.forEach {
            when (it) {
                '<' -> if (index != 0) index--
                '>' -> if (index != output.size) index++
                '-' -> if (index != 0) output.removeAt(--index)
                else -> output.add(index++, it)
            }
        }

        output.forEach { sb.append(it) }
        sb.append("\n")
    }

    print(sb)
}
