fun main(args: Array<String>) {
    val peopleVal = listOf<Person>()
    var people: List<Person?>? = null
    people = listOf(Person(23), Person(23), null)

/*    var utablePeople = mutableMapOf(Person(21),Person(22))
    // xxxOf is read-only
    utablePeople.add(null)*/

    // Java does not distinguish between mutable and immutable collections . so it can be tricky with overriding/implementing method ... is collection or thei memembers mutable/nullable
}

class Person(val age: Int) {}