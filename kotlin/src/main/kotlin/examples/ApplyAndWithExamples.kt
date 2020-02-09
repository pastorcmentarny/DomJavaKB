package examples

import java.util.*

data class User(val name: String)

class Appointment {
    var Title: String = ""
    var When: Date = Date()
    var Who = mutableListOf<String>()
    val people = listOf(User("Dom"), User("Tom"))


    fun create() {}
}

fun main(args: Array<String>) {
    println("With and Apply looks like")

    val a = Appointment()
    with(a) {
        Title = "Board meeting"
        When = Date(2018, 1, 1)
        Who.add("Kevin")
    } //it works like builder pattern

    a.apply {
        Title = "Board meeting"
        When = Date(2018, 1, 1)
        Who.add("Kevin")
    }.create() //it works like builder pattern*/

}

