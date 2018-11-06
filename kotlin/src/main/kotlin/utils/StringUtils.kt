package utils

class StringUtils(text:String) {
    init {
        println("Initializer block that prints ${text}")
    }

    fun returnLongerText(text1: String,text2: String): String{
       return if (text1.length > text2.length) text1 else if (text1.length < text2.length) text2 else ""
    }

    fun String.removeDuplicatedWhiteSpaces() : String {
        var regex = Regex("\\s+")
        return regex.replace(this," ")
    }


}