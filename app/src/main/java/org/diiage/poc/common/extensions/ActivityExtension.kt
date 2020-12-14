package org.diiage.poc.common.extensions

import android.app.Activity
import androidx.appcompat.app.ActionBar
import org.diiage.poc.ui.MainActivity

fun Activity.asMainActivity() = this as MainActivity
