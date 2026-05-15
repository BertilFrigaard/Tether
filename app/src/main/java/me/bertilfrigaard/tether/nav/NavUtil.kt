package me.bertilfrigaard.tether.nav

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

fun <T : NavKey> NavBackStack<T>.pushMaxOne(route: T) {
    if (lastOrNull() != route) add(route)
}

fun <T : NavKey> NavBackStack<T>.popOneMinOne() {
    if (size > 1) removeLastOrNull()
}