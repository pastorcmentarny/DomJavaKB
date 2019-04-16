package course

fun main(args: Array<String>) {
    val p = Person("Dom", 54)
    p.sign()

    println(p.partnerName)
    p.partnerName = "Jenny"
    println("Name of ${p.name} is ${p.partnerName}")

}


