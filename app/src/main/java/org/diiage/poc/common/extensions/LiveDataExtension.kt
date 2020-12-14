package org.diiage.poc.common.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeValue(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer { newVal: T ->
        newVal?.let(observer)
    })
}
fun <T> LiveData<T>.observeValueForever(observer: (t: T) -> Unit) {
    this.observeForever( Observer { newVal: T ->
        newVal?.let(observer)
    })
}
