// https://www.acmicpc.net/problem/15904

import java.io.*;

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(solution(readLine()))
}

fun solution(s: String): String {
    val ucpc: Array<Char> = arrayOf('U', 'C', 'P', 'C')
    var index = 0

    for (c in s) {
        if (c == ucpc[index]) {
            index++
        }
        if (index == 4) {
            return "I love UCPC"
        }
    }

    return "I hate UCPC"
}
