package course

import tools.security.Providers

fun main(args: Array<String>) {
    val p = Person("Dom", 54)
    p.sign()

    println(p.partnerName)
    p.partnerName = "Jenny"
    println("Name of ${p.name} is ${p.partnerName}")


/*
    //val user2 = p.copy(age=60)
    val (name, age) = p
    println("name: $name  is $age of age")
*/

    getAllProviders()
    getAllProviders{
        key, value -> println("\t ---- $key: $value") //it is like using strategy pattern in practice

    }

}

fun getAllProviders() {
    val allProviders = Providers.getProviders()
    val it = allProviders.iterator()
    while (it.hasNext()) {
        val provider = it.next()
        provider.forEach { key, value -> println("\t Key $key with value : $value") }
    }

}

fun getAllProviders(fn: (String,String) -> Unit) {
    val allProviders = Providers.getProviders()
    val it = allProviders.iterator()
    while (it.hasNext()) {
        val provider = it.next()
        provider.forEach { key, value -> fn(key.toString(),value.toString()) }
    }
}


