package com.example.snail.SnailCore


import kotlinx.cinterop.*
import platform.UIKit.UIDevice
import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithCString
import platform.posix.uname
import platform.posix.utsname

const val bundleNameKey = "CFBundleName"
const val bundleShortVersionStringKey = "CFBundleShortVersionString"
const val bundleVersionKey = "CFBundleVersion"

actual class Platform actual constructor() {

    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    actual val userAgentHeader: String get() {
        val currentDevice = UIDevice.currentDevice
        val infoDictionary = NSBundle.mainBundle.infoDictionary
        val appName = infoDictionary?.get(bundleNameKey).toString()
        val appVersion = infoDictionary?.get(bundleShortVersionStringKey).toString()
        val buildVersion = infoDictionary?.get(bundleVersionKey).toString()
        return "$appName; ${currentDevice.systemName}; $appVersion; $buildVersion; ${currentDevice.model}; ${currentDevice.systemName} ${currentDevice.systemVersion}; ${currentDevice.modelName}"
    }


    actual fun request() {
    }
}

val UIDevice.modelName: String get() {
    memScoped {
        val q = alloc<utsname>()
        uname(q.ptr)
        return NSString.stringWithCString(q.machine, encoding =  NSUTF8StringEncoding) ?: ""
    }
}

