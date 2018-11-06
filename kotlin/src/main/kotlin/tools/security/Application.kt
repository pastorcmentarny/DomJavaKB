package tools.security

fun main(args: Array<String>) {
    Providers.getProviders().forEach { provider -> println(provider.name) }
    Providers.getProviders().forEach { provider -> provider.forEach { key, value -> println("$key : $value") } }
}