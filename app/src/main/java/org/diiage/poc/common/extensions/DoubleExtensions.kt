@file:JvmName("DoubleUtils")
package org.diiage.poc.common.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.toDecimal(decimalNumber :Int): String {
    val df = DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.FRANCE))
    df.maximumFractionDigits = decimalNumber
    return df.format(this)
}