package org.diiage.poc.common.extensions

import android.widget.EditText

fun EditText.focus() {
    requestFocus()
    showKeyboard()
}

fun EditText.focusAndClear() {
    focus()
    text.clear()
}
