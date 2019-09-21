// https://www.acmicpc.net/problem/2178

import java.io.*
import java.util.*

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()
    val miro = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        readLine().forEachIndexed { index, value ->
            miro[i][index] = value - '0'
        }
    }

    println(bfs(n, m, miro))
}

fun bfs(n: Int, m: Int, miro: Array<IntArray>): Int {
    val visited = Array(n) { BooleanArray(m) }
    val q: Queue<Triple<Int, Int, Int>> = LinkedList<Triple<Int, Int, Int>>()
    q.add(Triple(0, 0, 1))  // (x 좌표, y 좌표, 지난 칸의 개수)
    visited[0][0] = true

    while (!q.isEmpty()) {
        val triple = q.poll()

        if (triple.first == n-1 && triple.second == m-1) {
            return triple.third
        }

        for(i in 0 until 4) {
            val x = triple.first + dx[i]
            val y = triple.second + dy[i]
            val count = triple.third

            if (x in 0 until n && y in 0 until m) {
                if (miro[x][y] == 1 && !visited[x][y]) {
                    q.add(Triple(x, y, count + 1))
                    visited[x][y] = true
                }
            }
        }
    }

    return 0
}
