@file:JvmName("StringUtils")
package org.diiage.poc.common.extensions

import android.graphics.Color
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun String.getColor(): Int {
    return Color.parseColor(this)
}
