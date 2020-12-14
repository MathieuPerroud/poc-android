package org.diiage.poc.common.extensions

import androidx.fragment.app.Fragment

fun Fragment.requireMainActivity() = requireActivity().asMainActivity()