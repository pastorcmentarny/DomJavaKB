package utils

class UIUtils {
    companion object {
        fun line(comment: String) {
            println()
            for (i in 1..40) {
                print("-")
            }
            println(comment)
            println()
        }

    }

}
