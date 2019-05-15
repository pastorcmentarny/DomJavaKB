package examples

fun main(args: Array<String>) {
    var program = Program()
    //1.  program.fibonacci(8)
    /*
    2. program.fibonacci(8,object : Process{
        override fun execute(value: Int) {
            println(value)
        }
    })
     */

    // program.fibonacci(8){n -> println(n)} // one solution
    program.fibonacci(8) { println(it) } // alternative solution
    program.fibonacci(8, ::println) // another alternative solution
    var total = 0
    program.fibonacci(8) { it -> total += it } //total is mutated
}

interface Process {
    fun execute(value: Int)
}

class Program {

    fun fibonacci(limit: Int) {
        var prev = 0
        var prevprev = 0
        var current = 1

        for (i: Int in 1..limit) {
            println(current)
            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    fun fibonacci(limit: Int, action: Process) {
        var prev = 0
        var prevprev = 0
        var current = 1

        for (i: Int in 1..limit) {
            action.execute(current)
            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    fun fibonacci(limit: Int, action: (Int) -> Unit) {
        var prev = 0
        var prevprev = 0
        var current = 1

        for (i: Int in 1..limit) {
            action(current)
            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

}

// lambda code inside {} is  . Take calue and pass it into this function and then do something with it. For example print(s)