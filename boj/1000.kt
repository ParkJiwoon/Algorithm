import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
}
