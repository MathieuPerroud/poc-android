@file:JvmName("MutableLiveDataUtils")
package org.diiage.poc.common.extensions

import androidx.lifecycle.MutableLiveData
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}
fun <T> MutableLiveData<T>.notifyObserverAsynchronous() = this.postValue(this.value)

fun <T> MutableLiveData<T>.init(initialValue: T) : MutableLiveData<T> {
    this.value = initialValue
    return this
}
