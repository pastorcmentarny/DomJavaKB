package examples

fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach { n ->
        sum += n
    }
    return sum
}

fun String.removeDuplicatedWhiteSpaces(): String {
    val regex = Regex("\\s+")
    return regex.replace(this, " ")
}

fun getPositiveIntegerValueFrom(numberAsString: String): Int {
    val result: Int = try {
        Integer.parseInt(numberAsString)
    } catch (e: NumberFormatException) {
        -1
    }
    if (result < -1) {
        return 0
    }
    return result
}
