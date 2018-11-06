package utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlin.reflect.KClass

object JsonUtils {
    fun <T : Any> String.toKotlinObject(c: KClass<T>): T {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(this, c.java)
    }
}