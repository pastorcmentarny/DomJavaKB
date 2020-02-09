package examples

class Course(val id: Int, val title: String) {
    fun display() {
        println("no. $id titled $title")
    }
}

// singleton can be consider as anti-pattern due troublesome testing
object Courses {
    var allCourses = arrayListOf<Course>() //properties

    fun initialize() {
        allCourses.add(Course(1, "Kotlin"))
    }
}