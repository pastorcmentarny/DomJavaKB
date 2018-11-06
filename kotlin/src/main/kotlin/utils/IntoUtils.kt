package utils

import tools.security.Providers

/**
 * Author Dominik Symonowicz
 * Created 02/11/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class InfoUtils(text: String) {
    init {
        println("Initializer block that prints ${text}")
    }

    fun displayAllProviders() {
        Providers.getProviders().forEach { provider -> provider.forEach { key, value -> println("$key : $value") } }
    }
}
