package utils

import io.kotlintest.specs.AbstractStringSpec

class StringUtilsTest : AbstractStringSpec() {
    init {
        val stringUtils = StringUtils("test")
        val returnLongerText = stringUtils.returnLongerText("text", "text2")
    }
}