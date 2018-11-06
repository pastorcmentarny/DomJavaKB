package domain

class Definition(what: String, definition: String) {

    init {
        println("$what \n{\t$definition\n}")
    }


    fun returnShortDefinition(what: String, definition: String): String {
        return "$what \n{\t${definition.substring(0..50)}\n}"
    }
}