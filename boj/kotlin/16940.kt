// https://www.acmicpc.net/problem/16940

import java.io.*
import java.util.*

class Node (var parent: Int, var childSize: Int)

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array<ArrayList<Int>>(n+1) { ArrayList() }

    repeat(n-1) {
        val node = readLine().split(" ")
        val v1 = node[0].toInt()
        val v2 = node[1].toInt()

        arr[v1].add(v2)
        arr[v2].add(v1)
    }

    val order = readLine().split(" ").map{ it.toInt() }
    val node: Array<Node> = Array(n+1) { Node(0, 0) }
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(n+1) { false }

    queue.add(1)
    visited[1] = true

    // BFS 돌면서 부모 노드, 자식 노드 갯수 구하기
    while (!queue.isEmpty()) {
        val now = queue.poll()

        arr[now].forEach {
            if (!visited[it]) {
                visited[it] = true
                node[it].parent = now
                node[now].childSize++
                queue.add(it)
            }
        }
    }

    // 노드가 A -> B 순서대로 나왔다면 뒤에서 A 자식노드 -> B 자식노드 순서대로 나와야한다
    // parentQueue 에는 order 순서대로 담으면서 자식노드가 전부 나올때까지 기다렸다가 부모노드를 교체해준다
    val parentQueue: Queue<Int> = LinkedList()
    var parent = 1
    for (i in 1 until n) {
        val now = order[i]
        if (parent != node[now].parent) {
            println(0)
            return
        }

        if (node[now].childSize > 0) parentQueue.add(now)
        node[parent].childSize--
        if (node[parent].childSize == 0 && i < n-1) parent = parentQueue.poll()
    }

    println(1)
}
