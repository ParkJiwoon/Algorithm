import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCase = Integer.parseInt(readLine())

    for(i in 1..testCase) {
        val st = StringTokenizer(readLine())
        val a = Integer.parseInt(st.nextToken())
        val b = Integer.parseInt(st.nextToken())

        println("Case #$i: $a + $b = ${a + b}")
    }
}
