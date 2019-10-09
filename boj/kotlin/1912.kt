// https://www.acmicpc.net/problem/1912

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val numbers = IntArray(n)
    val st = StringTokenizer(readLine()!!)

    repeat (n) { numbers[it] = st.nextToken().toInt() }

    var sum = 0
    var max = numbers[0]
    for (number in numbers) {
        sum += number
        max = max.coerceAtLeast(sum)
        if (sum < 0) sum = 0
    }
    println(max)
}
