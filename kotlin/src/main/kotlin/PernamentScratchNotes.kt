import domain.Definition
import java.util.*

class PernamentScratchNotes {
    // private val log = LoggerFactory.getLogger(PernamentScratchNotes::class.java)

    fun notes() {

        fun sayHello(name: String): Unit = print("Hello $name")
        println("Gohn")
        val text = """
            > It is time to learn Kotlin!
            > It is my first project with Kotlin and Spring Boot 2
            > It should be as useless as all my projects :)
            ${'$'}9.99

            """.trimMargin(); //  remove leading whitespace ${'$'}9.99 is used to type $
        for (letter in text) {
            println("Letter : $letter")
        }

        val array = arrayOf("Dominik", 35, true)
        array.iterator().forEach { x -> println(x) }
        array[1] = 36
        println(array.first())
        println(array.indexOf(array.last()))

        array.copyOfRange(0, 2).iterator().forEach { x -> println(x) }

        val oneToTen = 0..9
        val alpha = "A".."Z"

        print("Is U is in AlphaArray : ${"U" in alpha}")

        oneToTen.step(2)
                .reversed()
                .iterator()
                .forEach { number -> println(number) }
        val description = """
A vary vary very long description so it can be cut so it can fit nicely on console.
            This text should not be visible :)
"""
        val subject = "Test"
        val definition = Definition(subject, description)

        println(definition.returnShortDefinition(subject, description))


        val x = "Six"

        val number: Int = try {
            Integer.parseInt(x)
        } catch (e: NumberFormatException) {
            -1
        }

        val values = 1..10
        for (i in values step 2) {
            println(i)
        }

        line("Kotlin's for loop style// closed range  (different than java) ")
        for (i in 1..10 step 2) {
            println(i)
        }
        line("Java's for loop style Half-open range")
        for (i in 1 until 10 step 2) {
            println(i)
        }

        line("down to 1 example")

        for (i in 10 downTo 1 step 3) {
            println(i)
        }

        line("for loop for array's indecies ")

        val ints: Array<Int> = arrayOf(1, 4, 9, 16, 25)

        for (i in ints.indices) {
            println(i)
        }

        val intArray = intArrayOf(1, 4, 9, 16, 25)
        intArray.forEachIndexed { index, value -> println("@$index value is $value") }



        line("switch")
        val age = Random().nextInt(20)
        when (age) {
            0, 1, 2, 3, 4 -> println("Go to nursery")
            5 -> println("Go to Kindergarden")
            in 6..17 -> goToGrade(age)
            else -> println("Go to collage")
        }

        line("map loop")

        var ages = TreeMap<String, Int>()
        ages["Kelvin"] = 55
        ages["Sam"] = 24
        ages["Alex"] = 24
        ages["Harry"] = 26

        for ((name, old) in ages) {
            println("$name is $old years old.")
        }


        line("for loop with index")

        val numbers: IntArray = intArrayOf(1, 2, 4, 8, 16, 32)

        for ((index, value) in numbers.withIndex()) {
            println("$value is at index $index")
        }



        line("function expression")

        println(max(1, 2))

        line("default parametes")

        println(isItUsable())
        println(isItUsable(false))
        println(isItUsable(true))


        println(generateMessage(message = "This is an important message to you", priorityLevel = 3))


        line("Function extension based on String")

        println("A text with   many     many whitesspaces".removeDuplicatedWhiteSpaces())


        line("Infix functions")

        val h1 = Header("H1")
        val h2 = Header("H2")
        val h3 = h1 plus h2
        val h4 = Header("H4")
        val h5 = h1 + h4

        println(h3.Name)
        println(h5.Name)

        line("Tailrec keyword") // kotlin optmise this by converting to loop bytecode inside JVM to avoid stackoverflow

        val (i1, i2) = nextTwo(1)
        println(i1)
        println(i2)


        println(getSum(1, 2, 3, 4, 5, 6))

        val multiply = { num1: Int, num2: Int -> num1 * num2 }
        println(multiply(4, 5))

        line("Constructor")
        val specialStageRace = SpecialStageRace("Night Hawk")
        println(specialStageRace.indoorOnly)


        line("Data Classes")
        // provice a convenient way to override eq, hashcode and 2String should be immutable (ktolin provice copy(clone(
        val meeting1 = Meeting("Awesome", 9)
        val meeting2 = Meeting("Epic", 3)


        line("Companion Objects")

        /*
        Student.createPostgard("Posty")
        Student.createUndergradute("Undy")
         */

        line("Higher order functions")
        val numList = 1..20
        val evenList = numList.filter { it % 2 == 0 } //tag-it
        evenList.forEach { number -> println(number) }
        val multiply3 = makeMathFunction(3)
        println("5 * 3 = ${multiply3(5)}")
        val multiply2 = { num1: Int -> num1 * 2 }
        val numList2 = arrayOf(1, 2, 3, 4, 5)
        makeMathOnList(numList2, multiply2)

        line("Collections")
        val numList3 = 1..20
        val listSum = numList3.reduce { x, y -> x + y } //TODO need to understand it
        val listSum2 = numList3.fold(5) { x, y -> x + y } //TODO need to understand it
        println("Evnes: ${numList3.any() { it % 2 == 0 }}")
        println("Evnes: ${numList3.all() { it % 2 == 0 }}")
        val seven = numList3.map { it * 7 }.forEach { println(it) }

        val list1: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
        var listOf: List<Int> = listOf(1, 2, 3, 4, 5)
        println("Size: ${list1.size}")
        val subList = list1.subList(1, list1.size)
        println("Size: ${subList.size}")
        subList.forEach { println(it) }

        val mutableMap = mutableMapOf<Int, Any>()
        val map = mutableMapOf("A" to "Z", 2 to 32)
        map.forEach { x, y -> println("X: $x Y: $y") }

        for ((k, v) in map) {
            println("K: $k V: $v")
        }

        val animal = Animal("Dragon", 20.1, 13.6)
        animal.getInfo()
        val dog = Dog("Porky", 20.2, 13.6, "Mr. George Smith")
        dog.getInfo()

        var nullVall4 = returnNull()
        if (nullVall4 != null) {
            println(nullVall4.length)
        }

//        var nullVal5 = nullVall4!!.length

        line("With and Apply looks like")

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

        line("Fun with collections")
        // filter transform all collection to filter out unwanted item
        // map transform items
        val ints2 = listOf(1, 2, 3, 4, 5)

        ints2.filter { it < 4 }.map { it * it }.forEach(::println)


        val greaterThan3AsPredicate = { value: Int -> value > 3 }

        var largeInts = ints2.all(greaterThan3AsPredicate)
        println(largeInts)

        largeInts = ints2.any { greaterThan3AsFunction(it) }
        println(largeInts)
        largeInts = ints2.any(greaterThan3AsPredicate)
        println(largeInts)

        var numberOfLargeInts = ints2.count(greaterThan3AsPredicate)
        println(numberOfLargeInts)
        var firstLarge = ints2.first(greaterThan3AsPredicate)
        println(firstLarge)

        /*
        var notFound: Int? = ints2.first { it > 10}
        println(notFound)
         */

        //if map output produce List<List> People> then you should use flatmap  so you will get List<People> useful map as return list and if return stuff is list then you will get

        val meetings = listOf(Meeting("Board examples.organizer.Meeting", 404), Meeting("1 on 1", 301))

        line("sequence") // like stream in java
        meetings.asSequence()
                .filter { it.name.startsWith("1") }
                .map { it.name }
                .forEach { println(it) }


        line("higher order function ")
        val calcSomething: (Int, Int) -> Int = { x, y -> x + y }

        val inlineFunResult = first(ints2, { i -> i == 3 })

        println(inlineFunResult)


        println(calcSomething(1, 2))

        line("higher order function ")
        val names: List<String> = listOf("Darren", "Mark","Karl")
        val nameOf = names.iteamAt(0)
        println(nameOf)

        val n: Node<Int> = Node(2)
        println(n)

    }

    inline fun <T> first(items: List<T>, predicate: (T) -> Boolean): T {
        for (item in items) {
            if (predicate(item)) return item
        }
        throw Exception()
    }

    private fun greaterThan3AsFunction(it: Int) = it > 3


    private fun returnNull(): String? {
        return null
    }

    private fun makeMathFunction(num1: Int): (Int) -> Int = { num2 -> num1 + num2 }

    private fun makeMathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
        numList.forEach { println("MathOnList ${myFunc(it)}") }
    }


    private fun goToGrade(age: Int) {
        val grade = age - 5
        println("Go to grade $grade")
    }

    private fun line(comment: String) {
        println()
        for (i in 1..40) {
            print("-")
        }
        println(comment)
        println()

    }

    private fun max(a: Int, b: Int): Int = if (a > b) a else b

    private fun isItUsable(useIt: Boolean = true): String {
        return if (useIt) "YES" else "no"
    }


    private fun generateMessage(title: String = "A message to you.", message: String, priorityLevel: Int = 1): String {
        return "$title{priority: $priorityLevel}\n\t::::$message::::\n Have a nice day!"
    }

    fun String.removeDuplicatedWhiteSpaces(): String {
        var regex = Regex("\\s+")
        return regex.replace(this, " ")
    }

    fun nextTwo(int: Int): Pair<Int, Int> {
        return Pair(int + 1, int + 2)
    }


    fun getSum(vararg nums: Int): Int {
        var sum = 0
        nums.forEach { n ->
            sum += n
        }
        return sum
    }


}

fun <T> List<T>.iteamAt(ndx: Int): T {
    return this[ndx]
}


class Node<T : Number>(private val item: T) { // Node<T : Number> we constraint type
    fun value(): T {
        return item
    }
}

class Header(var Name: String) {}

// infix and operator overload . Useful for DSL stuff but not in general
operator infix fun Header.plus(other: Header): Header {
    return Header(this.Name + other.Name)
}

interface Time {
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
    fun setTime(time: KelvinTime) = setTime(time.hours)// default implemantion so all classes do not have implementation will use default implementaion
}

interface EndOfTheWorld {
    fun setTime(time: KelvinTime) {}
}

//example to deal with interfaces share the same function
class YetiTime : Time, EndOfTheWorld { // : is replacement for implements , extends
    override fun setTime(time: KelvinTime) {
        super<Time>.setTime(time)
        super<EndOfTheWorld>.setTime(time)
    }

    override fun setTime(hours: Int, mins: Int, secs: Int) {}

}

class KelvinTime { // : is replacement for implements , extends
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0

}

open class Device(name: String) { // primary constructor (better than seconday and yo ucan use default value
    constructor(name: String, serialNumber: Int) : this(name) /// secondary
}

abstract class Race(var name: String = "Race", var id: Int = 1) {
    fun getRaceDetails(): String = "Race: $id - $name"
}

data class Meeting(val name: String, val roomNumber: Int)

class SpecialStageRace(name: String = "Race", id: Int = 1, _indoorOnly: Boolean = false) : Race(name, id) {
    val indoorOnly: Boolean

    init {
        indoorOnly = _indoorOnly
    }

}


/*// open means can be overridden , abstract musb be overridden, default cannot be overriden
abstract class Person(var firstName: String, var lastName: String) { // open is to negate  final keyword used by default
    open fun getName(): String = "$firstName $lastName"
    abstract fun getAddress(): String

}*/


/*
open class Student(firstName: String, lastName: String, _id: Int, var tutor: String = "") : Person(firstName, lastName) {
    override fun getAddress(): String {
        return ""
    }

    val id: Int

    init {
        id = _id
    }

    fun enrol(courseName: String) {
        val course = Courses.allCourses
                .filter { it.Title == courseName }
                .firstOrNull()
    }

    companion object : XmlSerializer<Student> {
        fun createUndergradute(name: String): Undergarduate {
            return Undergarduate(name)

        }

        fun createPostgard(name: String): Postgarduate {
            return Postgarduate(name)
        }

        override fun toXml(item: Student) {

        }
    }
}

class Undergarduate(firstName: String) : Student(firstName, "Studentson" 1) {

}

class Postgarduate(firstName: String) : Student(firstName, "Postgradson" 1) {

}
 */

class Course(val Id: Int, val Title: String) {

}

// singleton can be consider as anti-pattern due troublesome testing
object Courses {
    var allCourses = arrayListOf<Course>() //properties

    fun initilialize() {
        allCourses.add(Course(1, "Kotlin"))
    }
}

interface XmlSerializer<T> {
    fun toXml(item: T)
}

// we can create nested object inside class

// kotlin do  not have static members
// companion object used for factory objects and static members or use as call main from Java ...


open class Animal(val name: String,
                  var height: Double,
                  var weight: Double) {
    init {
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) {
            "Animal name can't contain number"
        }
        require(height > 0) {
            "Height must be greater than zero"
        }
        require(weight > 0) {
            "Weight must be greater than zero"
        }
    }

    open fun getInfo(): Unit {
        println("$name is $height cm tall and it weight $weight")
    }
}

class Dog(name: String,
          height: Double,
          weight: Double,
          var owner: String) : Animal(name, height, weight) {
    override fun getInfo() {
        println("$name is $height cm tall and it weight $weight amd its owned by $owner")
    }
}


class Appointment {
    var Title: String = ""
    var When: Date = Date()
    var Who = mutableListOf<String>()
    val people = listOf(User("Dom"), User("Tom"))


    fun create() {}
}

data class User(val name: String)

class Event {
    var name: String = "Unknown"
}