package examples

fun nextTwo(int: Int): Pair<Int, Int> {
    return Pair(int + 1, int + 2)
}

fun main(args: Array<String>) {
    println(nextTwo(1))
}