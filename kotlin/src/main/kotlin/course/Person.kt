package course

open class Person(val name: String = "Unknown", var age:Int = 18, isMarried: Boolean = false) : Signatory {

/* constructor
    constructor(name: String, age:Int, isMarried: Boolean) : this(name,age) {
        this.isMarried = isMarried
    }
*/

    var partnerName: String = ""

    init {
        if(age <54) throw Exception("Invalid age")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
                val p = Person("Mark",21)
            p.sign()
        }
    }

    override fun sign() = println("$name aged $age signed documents") // method expression
}