package tools.security

import java.security.Provider
import java.security.Security

class Providers {
    companion object { // kotlin doesn't have static but it has companion object which a singleton instantce inside class
        fun getProviders(): List<Provider> {
            val providers = Security.getProviders()
            val listOfProvicers: List<Provider> = providers.asList()
            return listOfProvicers
        }

    }
}

