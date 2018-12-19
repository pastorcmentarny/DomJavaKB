package examples

import utils.UIUtils.Companion.line
import java.util.*

fun main(args: Array<String>) {
    line("switch")
    val age = Random().nextInt(20)
    when (age) {
        0, 1, 2, 3, 4 -> println("Go to nursery")
        5 -> println("Go to Kindergarden")
        in 6..17 -> goToGrade(age)
        else -> println("Go to collage")
    }
}

private fun goToGrade(age: Int) {
    val grade = age - 5
    println("Go to grade $grade")
}