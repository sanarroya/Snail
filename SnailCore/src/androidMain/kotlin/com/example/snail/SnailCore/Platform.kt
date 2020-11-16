package com.example.snail.SnailCore

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    actual val userAgentHeader: String = "Android Header"

    actual fun request() {

    }
}