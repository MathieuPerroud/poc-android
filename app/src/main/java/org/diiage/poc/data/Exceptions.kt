package org.diiage.poc.data

open class GenericNetworkException: Exception()

sealed class SpecialException(message: String) : Exception(message) {
    data class Timeout(override val message: String): SpecialException(message)
}