fun main(args: Array<String>) {
    val user = "Dominik"
    println("My name is $user")
    val scratchNotes = PernamentScratchNotes()
    scratchNotes.notes()

    var question = Question()
    question.printResult()
    question.Answer = "Dominik"
    question.printResult()


}


class Question {
    var Answer:String? = null
    val CorrectAnswer = "Dominik"
    val Question: String = "What is my number ?"

    fun display() {
        println("Your answer: $Answer ")
    }

    fun printResult() {
        when (Answer) {
            CorrectAnswer -> print("Awesome Answer!")
            else -> print("Try again ?")

        }
    }
}

