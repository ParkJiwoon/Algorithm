// https://www.acmicpc.net/problem/9012

import java.io.*;

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        if (isVPS(readLine())) bw.write("YES\n") else bw.write("NO\n")
    }
    bw.flush()
}

fun isVPS(s: String) : Boolean {
    var count = 0
    s.toCharArray().forEach {
        when(it) {
            '(' -> count++
            ')' -> if (count == 0) return false else count--
        }
    }
    return count == 0
}
